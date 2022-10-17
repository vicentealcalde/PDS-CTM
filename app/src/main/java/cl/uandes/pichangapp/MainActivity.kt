package cl.uandes.pichangapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cl.uandes.pichangapp.databinding.ActivityMainBinding
import cl.uandes.pichangapp.models.Match
import com.google.android.material.bottomnavigation.BottomNavigationView
import cl.uandes.pichangapp.models.Matches

val allMatches = Matches.createMatchList()
var allUserMatches: List<Match> = emptyList()
var otherPeoplesMatches: List<Match> = emptyList()
var allUserOrganizedMatches: List<Match> = emptyList()
var currentUser: String? = null
var teamName: String? = null
var category: String? = null

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navigationView: BottomNavigationView = binding?.navigationView!!

        navigationController = findNavController(R.id.nav_host_fragment_activity_main)
        NavigationUI.setupActionBarWithNavController(this, navigationController)

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_graph)
        )
        navigationController.addOnDestinationChangedListener { _, nd: NavDestination, _ ->
            if (nd.id == R.id.loginAccessFragment || nd.id == R.id.registerAccess01Fragment) {
                navigationView.visibility = View.GONE
            } else {
                navigationView.visibility = View.VISIBLE
            }
        }

        setupActionBarWithNavController(navigationController, appBarConfiguration)

        navigationView.setupWithNavController(navigationController)



    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navigationController, null)
    }


}


