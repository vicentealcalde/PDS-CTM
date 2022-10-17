package cl.uandes.pichangapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.databinding.FinishedMatchAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.ResultItemAdapter
import cl.uandes.pichangapp.api.ApiViewModel
import org.koin.android.ext.android.inject

class FinishedMatchAccessFragment: Fragment(), ResultItemAdapter.ActionListener {
    private lateinit var resultItemAdapter: ResultItemAdapter //
    private var _binding: FinishedMatchAccessFragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FinishedMatchAccessFragmentBinding.inflate(inflater, container, false)


        Log.d("Friends", "Before Adapter: $myFriends")
        resultItemAdapter = ResultItemAdapter(myFriends, this)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultListView = binding.resultListView
        resultListView.layoutManager = LinearLayoutManager(context)
        resultListView.adapter = resultItemAdapter
        filter()

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