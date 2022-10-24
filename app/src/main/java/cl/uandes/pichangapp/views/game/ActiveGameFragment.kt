package cl.uandes.pichangapp.views.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.*
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.databinding.ActiveGameFragmentBinding
import cl.uandes.pichangapp.models.User
import cl.uandes.pichangapp.viewModels.InGamePlayersViewModel
import org.koin.android.ext.android.inject

class ActiveGameFragment:  Fragment(), GameAdapter.ActionListener {
    private var _binding: ActiveGameFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var gameadapter: GameAdapter
    private val apiViewModel: ApiViewModel by inject()
    private val ingameplayersviewmodel: InGamePlayersViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActiveGameFragmentBinding.inflate(inflater, container, false)
        gameadapter = GameAdapter(this, apiViewModel)
        val resultLisThisWeek = binding.ActiveLobbyPlayersListView
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)
        resultLisThisWeek.adapter = gameadapter

        currentLobby?.let { apiViewModel.getInGamePlayersFromLobby(it.id) }
        if (currentUser?.id?.toInt() == currentLobby?.current_user) {
            currentLobby?.let { play_roll(it.id) }
        }

        ingameplayersviewmodel.getInGamePlayersFromLobby(currentLobby!!.id)
            .observe(viewLifecycleOwner) {
                gameadapter.set(it)
                gameadapter.notifyDataSetChanged()
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun play_roll(id: Int) {
        val button = _binding?.RollDicesButton
        button?.setOnClickListener {
            apiViewModel.playTurn(id)
            findNavController().navigate(R.id.action_activeGameFragment_to_resultRollFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun goToMatchDetails(match: Match) {
        //val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))
        //findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_expandToPlayFragment, bundle)
    }
}