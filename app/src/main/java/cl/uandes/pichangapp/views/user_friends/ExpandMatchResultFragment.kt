package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.pichangapp.ExpandMatchResultFragmentArgs
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.allUserMatches
import cl.uandes.pichangapp.databinding.ExpandMatchResultFragmentBinding
import cl.uandes.pichangapp.models.Match

class ExpandMatchResultFragment : Fragment() {
    private var _binding: ExpandMatchResultFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandMatchResultFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

            val matchIndex = ExpandMatchResultFragmentArgs.fromBundle(it).matchIndex
            println(matchIndex)
            setAttributesToItem(allUserMatches[matchIndex])
        }
    }

    private fun setAttributesToItem(match: Match) {

        val result = _binding?.resultTextView
        val NameTeam1 = _binding?.NameTeam1
        val NameTeam2 = _binding?.NameTeam2
        val DayOfMatch = _binding?.DayOfMatch
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1 = _binding?.ImageTeam1
        val ImageTeam2 = _binding?.ImageTeam2

        result?.text = match?.resultTextView
        DayOfMatch?.text = match?.DayOfMatch
        HourOfMatch?.text = match?.HourOfMatch
        LocationOfMatch?.text = match?.LocationOfMatch
        DescriptionOfMatch?.text = match?.DescriptionOfMatch

    }
}