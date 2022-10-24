package cl.uandes.pichangapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.databinding.MatchToPlayAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import androidx.core.os.bundleOf

import cl.uandes.pichangapp.MatchAdapter
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.databinding.GameBinding
import cl.uandes.pichangapp.viewModels.InGamePlayersViewModel
import org.koin.android.ext.android.inject

class GameFragment:  Fragment(), GameAdapter.ActionListener{
    private var _binding: GameBinding?= null
    private val binding get() = _binding!!
    private lateinit var gameadapter: GameAdapter
    private val apiViewModel: ApiViewModel by inject()
    private val ingameplayersviewmodel: InGamePlayersViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GameBinding.inflate(inflater, container, false)
        gameadapter = GameAdapter(this, apiViewModel)
        val resultLisThisWeek= binding.resultListView
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)

        resultLisThisWeek.adapter =gameadapter
        currentUser!!.id?.let { apiViewModel.getFriendRequests(it.toInt()) }

       // filter()

        ingameplayersviewmodel.getInGamePlayersFromLobby(lobbyId = id).observe(viewLifecycleOwner){
            gameadapter.set(it)
            gameadapter.notifyDataSetChanged()
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

/*
    private fun filter(){
        val button = _binding?.FilterInFinishedButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_filterMenuParticipatingFragment)
        }
    }
    */
    override fun goToMatchDetails(match: Match) {

        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))

        findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_expandToPlayFragment, bundle)
    }
}
