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
import cl.uandes.pichangapp.databinding.FragmentResultRollBinding
import cl.uandes.pichangapp.models.User
import cl.uandes.pichangapp.viewModels.InGamePlayersViewModel
import org.koin.android.ext.android.inject

class ResultRollFragment:  Fragment(), ResultRollAdapter.ActionListener {
    private var _binding: FragmentResultRollBinding?= null
    private val binding get() = _binding!!
    private lateinit var gameadapter:  ResultRollAdapter
    private val apiViewModel: ApiViewModel by inject()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultRollBinding.inflate(inflater, container, false)
        gameadapter =  ResultRollAdapter(this, apiViewModel)
        val resultLisThisWeek= binding.exit
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)

        resultLisThisWeek.adapter = gameadapter
        play_roll()


        // filter()
        //println("hola 3")
        apiViewModel.myRoll.observe(viewLifecycleOwner){
            gameadapter.set(it.body()!!)
            gameadapter.notifyDataSetChanged()
        }



        return binding.root
    }

    private fun play_roll() {
        val button = _binding?.button

        button?.setOnClickListener {

            apiViewModel.playTurn(currentLobby!!.id)
            findNavController().navigate(R.id.action_resultRollFragment_to_homeFragment)
        }
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