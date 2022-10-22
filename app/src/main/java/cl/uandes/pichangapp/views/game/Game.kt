package cl.uandes.pichangapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.uandes.pichangapp.databinding.ExpandgameBinding
import cl.uandes.pichangapp.models.Lobby
import cl.uandes.pichangapp.models.Match

class ExpandgameFragment : Fragment() {
    private var _binding: ExpandgameBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandgameBinding.inflate(inflater, container, false)
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
            //setAttributesToItem(allUserMatches[matchIndex])
        }
    }

    private fun setAttributesToItem(lobby: Lobby) {
        /*
        val result = _binding?.resultTextView

        val DayOfMatch = _binding?.DayOfMatch
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1 = _binding?.ImageTeam1
        val ImageTeam2 = _binding?.ImageTeam2

        result?.text = lobby?.resultTextView
        DayOfMatch?.text = lobby?.DayOfMatch
        HourOfMatch?.text = lobby?.HourOfMatch
        LocationOfMatch?.text = lobby?.LocationOfMatch
        DescriptionOfMatch?.text = lobby?.DescriptionOfMatch*/

    }
}