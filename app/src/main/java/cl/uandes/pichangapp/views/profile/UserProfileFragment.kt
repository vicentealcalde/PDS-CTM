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
import org.koin.android.ext.android.inject

class UserProfileFragment: Fragment() {
    private var _binding:UserProfileFragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserProfileFragmentBinding.inflate(inflater, container, false)

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
        val teamImage = _binding?.teamImage
        val textTeamNameBackground = _binding?.textTeamNameBackground
        val textTeamMailBackground = _binding?.textTeamMailBackground

        apiViewModel.myUser.observe(viewLifecycleOwner){
            Log.d("Login","Profile: $it")
            textTeamNameBackground?.text = it?.username
            textTeamMailBackground?.text = it?.password
        }



    }
}

