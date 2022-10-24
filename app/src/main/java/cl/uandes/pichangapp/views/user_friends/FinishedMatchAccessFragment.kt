package cl.uandes.pichangapp.views.user_friends

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.allUserMatches
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.databinding.FinishedMatchAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.viewModels.FriendViewModel
import org.koin.android.ext.android.inject

class FinishedMatchAccessFragment: Fragment(), ResultItemAdapter.ActionListener {
    private lateinit var resultItemAdapter: ResultItemAdapter
    private var _binding: FinishedMatchAccessFragmentBinding? = null
    private val binding get() = _binding!!
    private val friendViewModel: FriendViewModel by inject()
    private val apiViewModel: ApiViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FinishedMatchAccessFragmentBinding.inflate(inflater, container, false)

        resultItemAdapter = ResultItemAdapter(this)
        val resultListView = binding.resultListView
        resultListView.layoutManager = LinearLayoutManager(context)
        resultListView.adapter = resultItemAdapter
        filter()

        currentUser!!.id?.toInt()?.let { apiViewModel.getUserFriends(it) }

        friendViewModel.getAcceptedFriends().observe(viewLifecycleOwner){
            resultItemAdapter.set(it)
            resultItemAdapter.notifyDataSetChanged()
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


    private fun filter() {
        val button = _binding?.FilterInFinishedButton

        button?.setOnClickListener {
            findNavController().navigate(R.id.action_finishedMatchAccessFragment_to_menuMatchEndFragment)
        }
    }

    override fun goToMatchDetails(match: Match) {
        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))
        findNavController().navigate(R.id.action_finishedMatchAccessFragment_to_expandMatchResultFragment, bundle)
    }

}