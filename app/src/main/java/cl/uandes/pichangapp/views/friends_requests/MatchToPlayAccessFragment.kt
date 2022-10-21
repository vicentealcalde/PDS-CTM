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
import cl.uandes.pichangapp.viewModels.FriendViewModel
import org.koin.android.ext.android.inject

class MatchToPlayAccessFragment:  Fragment(), MatchAdapter.ActionListener{
    private lateinit var matchadapter: MatchAdapter
    private var _binding: MatchToPlayAccessFragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()
    private val friendViewModel: FriendViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MatchToPlayAccessFragmentBinding.inflate(inflater, container, false)
        matchadapter = MatchAdapter(this, apiViewModel)
        val resultLisThisWeek= binding.resultListView
        resultLisThisWeek.layoutManager = LinearLayoutManager(context)

        resultLisThisWeek.adapter = matchadapter
        currentUser!!.id?.let { apiViewModel.getFriendRequests(it.toInt()) }

        filter()

        friendViewModel.getFriendRequests().observe(viewLifecycleOwner){
            matchadapter.set(it)
            matchadapter.notifyDataSetChanged()
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


