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
import cl.uandes.pichangapp.databinding.OrganizedMatchAccessFragmentBinding
import cl.uandes.pichangapp.databinding.SearchCreateAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.views.home.OrganizedMatchAdapter

class SearchCreateAccessFragment: Fragment(), OrganizedMatchAdapter.ActionListener {

    private var _binding: SearchCreateAccessFragmentBinding? = null
    private lateinit var searchdmatchadapter: OrganizedMatchAdapter
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchCreateAccessFragmentBinding.inflate(inflater, container, false)
        searchdmatchadapter = OrganizedMatchAdapter( this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val organizedListView = binding.SearchtListView
        organizedListView.layoutManager = LinearLayoutManager(context)
        organizedListView.adapter = searchdmatchadapter

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


    override fun goToMatchDetails(match: Match) {
        val bundle = bundleOf("matchIndex" to otherPeoplesMatches.indexOf(match))
        findNavController().navigate(R.id.action_homeFragment_to_expandMatchAddInformationFragment2, bundle)
    }
}

