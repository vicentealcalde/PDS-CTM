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

class MatchToPlayAccessFragment:  Fragment(), MatchAdapter.ActionListener{
    private lateinit var matchadapter: MatchAdapter
    private var _binding: MatchToPlayAccessFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MatchToPlayAccessFragmentBinding.inflate(inflater, container, false)



        matchadapter = MatchAdapter(allUserMatches.toMutableList(), this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val resultLisThisWeek= binding.resultListView
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)

        resultLisThisWeek.adapter = matchadapter


        filter()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    private fun filter(){
        val button = _binding?.FilterInFinishedButton
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_filterMenuParticipatingFragment)
        }
    }
    override fun goToMatchDetails(match: Match) {

        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))

        findNavController().navigate(R.id.action_matchToPlayAccessFragment_to_expandToPlayFragment, bundle)
    }
}


