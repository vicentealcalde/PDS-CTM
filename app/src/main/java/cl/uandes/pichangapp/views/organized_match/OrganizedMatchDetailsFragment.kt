package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.ExpandOrganizedInformationFragmentBinding
import cl.uandes.pichangapp.models.Match

class OrganizedMatchDetailsFragment : Fragment() {
    private var _binding: ExpandOrganizedInformationFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandOrganizedInformationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

            var matchIndex = ExpandMatchResultFragmentArgs.fromBundle(it).matchIndex
            println(matchIndex)
            setAttributesToItem(allUserOrganizedMatches[matchIndex])

        }

        delete_match()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




    private fun delete_match() {
        val button = _binding?.DeleteMatchButton

        button?.setOnClickListener {
            findNavController().navigate(R.id.action_expandOrganizedInformationFragment_to_organizedMatchAccessFragment)
        }
    }


    private fun setAttributesToItem(match: Match) {

        val user=allUsers.find{ it.mail == match?.OrganaizerTeam }


        val NameTeam = _binding?.NameTeam
        val DayOfMatch = _binding?.DayOfMatch
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam = _binding?.ImageTeam

        NameTeam?.text = user?.name
        DayOfMatch?.text = match?.DayOfMatch
        HourOfMatch?.text = match?.HourOfMatch
        LocationOfMatch?.text = match?.LocationOfMatch
        DescriptionOfMatch?.text = match?.DescriptionOfMatch
        ImageTeam?.setImageResource(user?.image!!)

    }
}