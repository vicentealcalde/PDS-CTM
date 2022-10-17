package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.api.UserObject
import cl.uandes.pichangapp.databinding.RegisterAccess01FragmentBinding
import cl.uandes.pichangapp.models.User
import org.koin.android.ext.android.inject

class RegisterAccess01Fragment : Fragment() {
    private var _binding: RegisterAccess01FragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterAccess01FragmentBinding.inflate(inflater, container, false)

        val usernameTextView = _binding!!.editTextUsername
        val passwordTextView = _binding!!.editTextPassword

        _binding!!.DoneButton.setOnClickListener{
            apiViewModel.registerUser(usernameTextView.text.toString(), passwordTextView.text.toString())
            findNavController().navigate(R.id.action_registerAccess01Fragment_to_loginAccessFragment)
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
}
