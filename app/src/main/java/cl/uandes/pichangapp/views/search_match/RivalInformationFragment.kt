package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.pichangapp.databinding.RivalInformationFragmentBinding
import cl.uandes.pichangapp.models.Match

class RivalInformationFragment: Fragment() {
    private var _binding: RivalInformationFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = RivalInformationFragmentBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
        val matchIndex = ExpandMatchResultFragmentArgs.fromBundle(it).matchIndex
        setAttributesToItem(allUserMatches[matchIndex] )
    }}

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setAttributesToItem(match: Match) {

        val NameTeam = _binding?.NameTeam
        val ImageTeam = _binding?.ImageTeam
        val TotalMatches = _binding?.TotalMatches
        val Victories = _binding?.Victories
        val Ties = _binding?.Ties
        val Lose = _binding?.Lose



    }
}