package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.RegisterAccess01FragmentBinding
import cl.uandes.pichangapp.models.Users

class RegisterAccess01Fragment : Fragment() {
    private var _binding: RegisterAccess01FragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RegisterAccess01FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menu()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun menu(){
        val Button = _binding?.DoneButton
        val editTextMail = _binding?.editTextMail!!
        val editTextPassword = _binding?.editTextPassword!!
        val editTextTeamName = _binding?.editTextTeamName!!
        val editTextCategory = _binding?.editTextCategory!!


        Button?.setOnClickListener {
            val arg1 = editTextMail.text.toString()
            val arg2 = editTextPassword.text.toString()
            val arg3 = editTextTeamName.text.toString()
            val arg4 = editTextCategory.text.toString()

            if (newUser(arg1)){
                currentUser =  arg1
                teamName = arg3
                category = arg4
                if (currentUser== ""|| teamName==""||category==""){
                    Toast.makeText(context, "Campos Vacíos", Toast.LENGTH_LONG).show()
                }
                else {
                    Users.createUser(arg1, arg2, arg3, arg4, R.drawable.extra_logo_chelsea)
                    findNavController().navigate(R.id.action_registerAccess01Fragment_to_search_match_navigation)
                }
            }
            else {
                Toast.makeText(context, "Mail ya registrado", Toast.LENGTH_LONG).show()

            }


        }
    }

    private fun newUser(userMail: String ): Boolean{
        allUsers.find{it.mail==userMail} ?: return true
        return false
    }
}