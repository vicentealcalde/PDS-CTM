package cl.uandes.pichangapp.views.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.models.Match
import androidx.core.os.bundleOf
import cl.uandes.pichangapp.*
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.databinding.GameFragmentBinding
import cl.uandes.pichangapp.models.User
import cl.uandes.pichangapp.viewModels.InGamePlayersViewModel
import org.koin.android.ext.android.inject

class GameFragment:  Fragment(), GameAdapter.ActionListener {
    private var _binding: GameFragmentBinding?= null
    private val binding get() = _binding!!
    private lateinit var gameadapter: GameAdapter
    private val apiViewModel: ApiViewModel by inject()
    private val ingameplayersviewmodel: InGamePlayersViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GameFragmentBinding.inflate(inflater, container, false)
        gameadapter = GameAdapter(this, apiViewModel)
        val resultLisThisWeek= binding.ResultListView
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)
        resultLisThisWeek.adapter =gameadapter

        currentLobby?.let { apiViewModel.getInGamePlayersFromLobby(it.id) }
        currentLobby?.let { start_game(it.id) }
        add()
        ingameplayersviewmodel.getInGamePlayersFromLobby(currentLobby!!.id).observe(viewLifecycleOwner){
            gameadapter.set(it)
            gameadapter.notifyDataSetChanged()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)



    }
    private fun start_game(id: Int) {
        val button = _binding?.RollButton
        button?.setOnClickListener {
            currentLobby?.let { it1 -> apiViewModel.startGame(it1.id) }
            println("hola desde afuera")
            findNavController().navigate(R.id.action_gameFragment3_to_activeGameFragment)
        }
    }
    private fun add() {
        val button = _binding?.powerButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_gameFragment3_to_addFriendParty)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun goToMatchDetails(match: Match) {

        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))

        findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_expandToPlayFragment, bundle)
    }
}