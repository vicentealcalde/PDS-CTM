package cl.uandes.pichangapp.views.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.FragmentLoginAccessBinding
import androidx.lifecycle.ViewModelProvider
import cl.uandes.pichangapp.MainActivity
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.api.UserObject
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.viewModels.FriendViewModel
import cl.uandes.pichangapp.viewModels.UserViewModel
import org.koin.android.ext.android.inject


class LoginAccessFragment : Fragment() {
    private var _binding: FragmentLoginAccessBinding? = null
    private val binding get() = _binding!!

    private val apiViewModel: ApiViewModel by inject()
    private val friendViewModel: FriendViewModel by inject()
    private val userViewModel: UserViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginAccessBinding.inflate(inflater, container, false)



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

            apiViewModel.getLogin(UserObject(stringMail, stringPassword))
            apiViewModel.myResponse.observe(activity as MainActivity) { response ->
                if (response.isSuccessful) {
                    try {
                        currentUser = response.body()?.get(0)
                        friendViewModel.executor.execute {
                            friendViewModel.deleteAllFriends()
                            userViewModel.deleteAllNoFriends()
                        }
                        findNavController().navigate(R.id.action_loginAccessFragment_to_search_match_navigation)
                    }
                    catch (e: Exception){
                        Log.e("Error","Login Error: $e")
                    }
                }
                else {
                    Toast.makeText(activity as MainActivity,"Incorrect Login", Toast.LENGTH_SHORT).show()
                }
            }




        }
    }

    private fun register(){
        val registerButton = _binding?.RegisterButton

        registerButton?.setOnClickListener {
            findNavController().navigate(R.id.action_loginAccessFragment_to_registerAccess01Fragment)
        }
    }
}



