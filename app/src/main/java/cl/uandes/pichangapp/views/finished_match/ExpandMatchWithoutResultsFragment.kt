package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.pichangapp.databinding.ExpandMatchWithoutResultsFragmentBinding

class ExpandMatchWithoutFragment : Fragment() {
    private var _binding: ExpandMatchWithoutResultsFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExpandMatchWithoutResultsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAttributesToItem()
    }
    private fun setAttributesToItem() {
        val match = allMatches.find{ it.OrganaizerTeam == currentUser }
        val userRival = allUsers.find{it.mail == match?.RivalTeam}
        val userOrganaizerTeam = allUsers.find{it.mail == match?.OrganaizerTeam}

        val NameTeam1 = _binding?.NameTeam1
        val NameTeam2 = _binding?.NameTeam2
        val DayOfMatch = _binding?.DayOfMatch
        val HourOfMatch = _binding?.HourOfMatch
        val LocationOfMatch = _binding?.LocationOfMatch
        val DescriptionOfMatch = _binding?.DescriptionOfMatch
        val ImageTeam1 = _binding?.ImageTeam1
        val ImageTeam2 = _binding?.ImageTeam2


        NameTeam1?.text = userOrganaizerTeam?.name
        NameTeam2?.text = userRival?.name
        DayOfMatch?.text = match?.DayOfMatch
        HourOfMatch?.text = match?.HourOfMatch
        LocationOfMatch?.text = match?.LocationOfMatch
        DescriptionOfMatch?.text = match?.DescriptionOfMatch
        ImageTeam2?.setImageResource(userRival?.image!!)
        ImageTeam1?.setImageResource(userOrganaizerTeam?.image!!)



    }

}