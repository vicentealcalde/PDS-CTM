package cl.uandes.pichangapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.api.AddLobbyObject
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.databinding.CreateMatchFragmentBinding
import org.koin.android.ext.android.inject


class CreateMatchFragment: Fragment() {
    private var _binding: CreateMatchFragmentBinding? = null
    private val binding get() = _binding!!
    private val apiViewModel: ApiViewModel by inject()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CreateMatchFragmentBinding
            .inflate(inflater, container, false)
        val createGameButton = _binding?.CreateGameButton

        createGameButton?.setOnClickListener {
            val diceNumber = _binding!!.editDicesNumber.text.toString().toInt()
            apiViewModel.createLobby(AddLobbyObject(0, diceNumber, 0, 1))
            findNavController().navigate(R.id.action_createMatchFragment_to_homeFragment)

        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        home()
    }

    private fun home(){

    }
}