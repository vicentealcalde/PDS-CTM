package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.ExpandToPlayFragmentBinding
import cl.uandes.pichangapp.models.Match

class ExpandToPlayFragment : Fragment() {
    private var _binding: ExpandToPlayFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandToPlayFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            // los parametros que me pase el otro fragment
            val matchIndex = ExpandMatchResultFragmentArgs.fromBundle(it).matchIndex
            rival_info(allUserMatches[matchIndex])
            setAttributesToItem(allUserMatches[matchIndex])
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun rival_info(match: Match) {
        val button = _binding?.RivalInfoButton
        val bundle = bundleOf("matchIndex" to allUserMatches.indexOf(match))
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_expandToPlayFragment_to_rivalInformationFragment2,bundle)
        }
    }

    private fun setAttributesToItem(match: Match) {

        val textDayOfMatch = _binding?.DataDatePlayMatch
        val NameTeam1 = _binding?.NameTeam1
        val HourOfMatch = _binding?.HourOfMatch
        val DayOfMatch = _binding?.DataDatePlayMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1= _binding?.ImageTeam1

        textDayOfMatch?.text = match?.DayOfMatch

        HourOfMatch?.text = match?.HourOfMatch
        DayOfMatch?.text = match?.DayOfMatch
        LocationOfMatch?.text = match?.LocationOfMatch
        DescriptionOfMatch?.text = match?.DescriptionOfMatch



    }


}