package cl.uandes.pichangapp.views.profile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.currentUser

import cl.uandes.pichangapp.databinding.UserProfileFragmentBinding
import cl.uandes.pichangapp.teamName
import cl.uandes.pichangapp.viewModels.UserStatsViewModel
import org.koin.android.ext.android.inject

class UserProfileFragment: Fragment() {
    private var _binding:UserProfileFragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()
    private val userStatsViewModel: UserStatsViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserProfileFragmentBinding.inflate(inflater, container, false)

        currentUser!!.id?.let {
            apiViewModel.updateUserStats(it.toInt())
        }

        val textLost = _binding?.textLost
        val textNemesis =_binding?.textNemesis
        val textMostCommon = _binding?.textMostCommon
        val textDamage = _binding?.textDamage
        val textLeastCommon = _binding?.textLeastCommon
        val textRoundOneDice = _binding?.textRoundOne

        userStatsViewModel.getUserStats().observe(viewLifecycleOwner){
            textLost?.text = it.losts.toString()
            textNemesis?.text = it.nemesis.toString()
            textMostCommon?.text = it.the_most.toString()
            textDamage?.text = it.damage.toString()
            textLeastCommon?.text = it.the_least.toString()
            textRoundOneDice?.text = it.rounds_with_one.toString()
        }

        setAttributesToItem()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileAction()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun profileAction() {
        val profileButton = _binding?.signOutButton

        profileButton?.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFragment_to_login_navigation)
        }
    }

    private fun setAttributesToItem() {
        val textUsername = _binding?.textTeamNameBackground
        val textGames = _binding?.textGames



        textUsername?.text = currentUser?.username
        textGames?.text = currentUser?.matches.toString()




    }
}

