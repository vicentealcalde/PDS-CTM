package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.databinding.HomeFragmentBinding
import cl.uandes.pichangapp.views.viewModels.FriendViewModel
import cl.uandes.pichangapp.views.viewModels.UserViewModel
import org.koin.android.ext.android.inject


class HomeFragment: Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    private val friendViewModel: FriendViewModel by inject()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding
            .inflate(inflater, container, false)




        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expand()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun expand(){
        val searchCreateAccessFragment = SearchCreateAccessFragment()
        activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.home_fragment, searchCreateAccessFragment)
            ?.commit()
    }
}