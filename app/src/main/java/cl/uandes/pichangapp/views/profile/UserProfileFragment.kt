package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import cl.uandes.pichangapp.databinding.UserProfileFragmentBinding

class UserProfileFragment: Fragment() {
    private var _binding:UserProfileFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileAction()
        setAttributesToItem()
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
        val textTeamCategoryBackground = _binding?.textTeamCategoryBackground

        textTeamNameBackground?.text = teamName
        textTeamMailBackground?.text = currentUser
        textTeamCategoryBackground?.text = category

    }
}

