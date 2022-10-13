package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.FragmentLoginAccessBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import cl.uandes.pichangapp.models.Match


class LoginAccessFragment : Fragment() {
    private var _binding: FragmentLoginAccessBinding? = null
    private val binding get() = _binding!!



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

            if (validateUser(stringMail,stringPassword)){
                findNavController().navigate(R.id.action_loginAccessFragment_to_search_match_navigation)
            }
            else{
                Toast.makeText(context, "Credenciales inválidas", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun register(){
        val registerButton = _binding?.RegisterButton

        registerButton?.setOnClickListener {
            findNavController().navigate(R.id.action_loginAccessFragment_to_registerAccess01Fragment)
        }
    }

    private fun validateUser(userMail: String,password: String ): Boolean{
        val user=allUsers.find{ it.mail == userMail }

        if (user?.password== password){
            currentUser = userMail
            teamName = user?.name
            category = user?.category

            allUserMatches = allMatches.filter{
                it.OrganaizerTeam!!
                    .contains(userMail) ||
                it.RivalTeam!!
                    .contains(userMail)
            } as ArrayList<Match>

            allUserOrganizedMatches = allMatches.filter{
                it.OrganaizerTeam!!
                    .contains(userMail)
            } as ArrayList<Match>

            otherPeoplesMatches= allMatches.filterNot{
                it.OrganaizerTeam!!
                    .contains(userMail)
            } as ArrayList<Match>

            return true}
        return false
    }
}



