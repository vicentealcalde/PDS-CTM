package cl.uandes.pichangapp

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
import cl.uandes.pichangapp.databinding.FragmentAddFriendPartyBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.viewModels.FriendViewModel
import cl.uandes.pichangapp.views.lobbies.FriendAdapter
import org.koin.android.ext.android.inject

class AddFriendParty: Fragment(), FriendAdapter.ActionListener {
    private lateinit var resultItemAdapter:FriendAdapter
    private var _binding: FragmentAddFriendPartyBinding? = null
    private val binding get() = _binding!!
    private val friendViewModel: FriendViewModel by inject()
    private val apiViewModel: ApiViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddFriendPartyBinding.inflate(inflater, container, false)

        resultItemAdapter = FriendAdapter(this)
        val resultListView = binding.OrganizedtListView
        resultListView.layoutManager = LinearLayoutManager(context)
        resultListView.adapter = resultItemAdapter


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




    override fun goToMatchDetails(match: Match) {
        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))
        findNavController().navigate(R.id.action_finishedMatchAccessFragment_to_expandMatchResultFragment, bundle)
    }

}