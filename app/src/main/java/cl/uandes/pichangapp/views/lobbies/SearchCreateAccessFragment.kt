package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.databinding.OrganizedMatchAccessFragmentBinding
import cl.uandes.pichangapp.databinding.SearchCreateAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.viewModels.LobbyViewModel
import cl.uandes.pichangapp.views.home.LobbyAdapter
import org.koin.android.ext.android.inject

class SearchCreateAccessFragment: Fragment(), LobbyAdapter.ActionListener {

    private var _binding: SearchCreateAccessFragmentBinding? = null
    private lateinit var lobbyAdapter: LobbyAdapter
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()
    private val lobbyViewModel: LobbyViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchCreateAccessFragmentBinding.inflate(inflater, container, false)
        lobbyAdapter = LobbyAdapter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val organizedListView = binding.SearchtListView
        organizedListView.layoutManager = LinearLayoutManager(context)
        organizedListView.adapter = lobbyAdapter

        // API call
        currentUser!!.id?.let {
            apiViewModel.getUserLobbies(it.toInt())
            apiViewModel.getUserPendingLobbies(it.toInt())
        }

        //Update View when local DB changes are detected
        lobbyViewModel.getUserLobbies().observe(viewLifecycleOwner){
            lobbyAdapter.set(it)
            lobbyAdapter.notifyDataSetChanged()
        }

        addmatch()
        filter()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun addmatch(){
        val button = _binding?.AddInMatchButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createMatchFragment)
        }
    }

    private fun filter(){
        val button = _binding?.FilterInMatchButton

        button?.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_menuFilterFragment)
        }

    }


    override fun goToGameDetails(match: Int) {
        val bundle = bundleOf("Id" to match)
        findNavController().navigate(R.id.action_homeFragment_to_gameFragment3 , bundle)
    }

    override fun goToStartedMatch(id: Int) {
        val bundle = bundleOf("Id" to id)
        findNavController().navigate(R.id.action_homeFragment_to_activeGameFragment , bundle)
    }
}

