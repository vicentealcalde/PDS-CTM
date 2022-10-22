package cl.uandes.pichangapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cl.uandes.pichangapp.models.Lobby

class ExpandgameFragment : Fragment() {
    private var _binding: gameBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = gameBinding.inflate(inflater, container, false)
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

    private fun setAttributesToItem(Lobby: loby) {

        val result = _binding?.resultTextView

        val DayOfMatch = _binding?.DayOfMatch
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1 = _binding?.ImageTeam1
        val ImageTeam2 = _binding?.ImageTeam2

        result?.text = loby?.resultTextView
        DayOfMatch?.text = loby?.DayOfMatch
        HourOfMatch?.text = loby?.HourOfMatch
        LocationOfMatch?.text = loby?.LocationOfMatch
        DescriptionOfMatch?.text = loby?.DescriptionOfMatch

    }
}