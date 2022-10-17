package cl.uandes.pichangapp.views.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.FragmentLoginAccessBinding
import androidx.lifecycle.ViewModelProvider
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.api.UserObject
import cl.uandes.pichangapp.R


class LoginAccessFragment : Fragment() {
    private var _binding: FragmentLoginAccessBinding? = null
    private val binding get() = _binding!!

    private lateinit var apiViewModel: ApiViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginAccessBinding.inflate(inflater, container, false)

        apiViewModel = ViewModelProvider(this)[ApiViewModel::class.java]

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        loginAction()
        register()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun loginAction() {
        val loginButton = _binding?.SignUpButton

        val editTextMail = _binding?.editTextMail!!
        val editTextPassword = _binding?.editTextPassword!!


        loginButton?.setOnClickListener {
            val stringMail = editTextMail.text.toString()
            val stringPassword = editTextPassword.text.toString()

            val loginResponse = apiViewModel.getLogin(
                UserObject(stringMail, stringPassword)
            )
            Log.d("Login","Login: $loginResponse")

            findNavController().navigate(R.id.action_loginAccessFragment_to_search_match_navigation)

        }
    }

    private fun register(){
        val registerButton = _binding?.RegisterButton

        registerButton?.setOnClickListener {
            findNavController().navigate(R.id.action_loginAccessFragment_to_registerAccess01Fragment)
        }
    }
}



