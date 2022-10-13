package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.databinding.ExpandMatchAddInformationFragmentBinding
import cl.uandes.pichangapp.models.Match


class MatchAddInformationFragment : Fragment() {
    private var _binding: ExpandMatchAddInformationFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandMatchAddInformationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            var matchIndex = ExpandMatchResultFragmentArgs.fromBundle(it).matchIndex
            println(matchIndex)
            setAttributesToItem(otherPeoplesMatches[matchIndex])
            rival_info(otherPeoplesMatches[matchIndex])
        }
        back()

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun back(){
        val button = _binding?.AddInMatchButton

        button?.setOnClickListener {
            findNavController().navigate(R.id.action_expandMatchAddInformationFragment2_to_homeFragment)
        }
    }

    private fun rival_info(match: Match){
        val button = _binding?.RivalInfoButton
        val bundle = bundleOf("matchIndex" to otherPeoplesMatches.indexOf(match))
        button?.setOnClickListener {
            findNavController().navigate(R.id.action_expandMatchAddInformationFragment2_to_rivalInformationFragment,bundle)
        }
    }

    private fun setAttributesToItem(match: Match) {



        val user=allUsers.find{ it.mail == match?.OrganaizerTeam }

        val MatchDay0 = _binding?.MatchDay
        val NameTeam1 = _binding?.NameTeam1
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1 = _binding?.ImageTeam1


        MatchDay0?.text = match.DayOfMatch
        NameTeam1?.text = user?.name
        HourOfMatch?.text = match?.HourOfMatch
        LocationOfMatch?.text = match?.LocationOfMatch
        DescriptionOfMatch?.text = match?.DescriptionOfMatch
        ImageTeam1?.setImageResource(user?.image!!)
    }
}


