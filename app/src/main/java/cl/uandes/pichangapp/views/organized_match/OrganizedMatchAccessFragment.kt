package cl.uandes.pichangapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.pichangapp.databinding.OrganizedMatchAccessFragmentBinding
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.views.home.OrganizedMatchAdapter

class OrganizedMatchAccessFragment : Fragment(), OrganizedMatchAdapter.ActionListener{
    private lateinit var organizedmatchadapter: OrganizedMatchAdapter
    private var _binding: OrganizedMatchAccessFragmentBinding? = null
    private val binding get() = _binding!!
    var MatchDate=""
    var Hour=""
    var Place=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = OrganizedMatchAccessFragmentBinding.inflate(inflater, container, false)
        organizedmatchadapter = OrganizedMatchAdapter(allUserOrganizedMatches.toMutableList(), this)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val organizedListView = binding.OrganizedtListView
        organizedListView.layoutManager = LinearLayoutManager(context)
        organizedListView.adapter = organizedmatchadapter
        //expand()
        filter()
        //setAttributesToItem()
    }

    private fun expand(){
        val button = _binding?.linearLayout4

        button?.setOnClickListener {

            val bundle = bundleOf("MatchDay" to MatchDate, "dataHour" to Hour, "dataPlace" to Place)
            Navigation.findNavController(it).navigate(R.id.action_organizedMatchAccessFragment_to_expandOrganizedInformationFragment, bundle)
        }
    }

    private fun filter(){
        val button = _binding?.FilterInOrganizedButton

        button?.setOnClickListener {
            findNavController().navigate(R.id.action_organizedMatchAccessFragment_to_organizedFilterFragment2)
        }
    }

    private fun setAttributesToItem() {
        /*
        val match = allMatches.find{ it.OrganaizerTeam == currentUser }
        val MatchDay = _binding?.MatchDay
        val dataHour = _binding?.dataHour
        val data_place = _binding?.dataPlace

        MatchDay?.text = match?.DayOfMatch
        dataHour?.text=match?.HourOfMatch
        data_place?.text=match?.LocationOfMatch

        MatchDate= match?.DayOfMatch!!
        Hour= match?.HourOfMatch!!
        Place= match?.LocationOfMatch!!

         */

    }

    override fun goToMatchDetails(match: Match) {
        val bundle = bundleOf("matchIndex" to allUserOrganizedMatches.indexOf(match))
        findNavController().navigate(R.id.action_organizedMatchAccessFragment_to_expandOrganizedInformationFragment, bundle)
    }
}
