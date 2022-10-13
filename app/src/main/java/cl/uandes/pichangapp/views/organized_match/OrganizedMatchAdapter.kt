package cl.uandes.pichangapp.views.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.allUsers

class OrganizedMatchAdapter (
    private val matches: MutableList<Match>,
    private val actionListener: ActionListener
): RecyclerView.Adapter<OrganizedMatchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!
        val textView2 = itemView.findViewById<TextView>(R.id.textView2)!!
        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!
        val textView6= itemView.findViewById<TextView>(R.id.textView6)!!
        val button = itemView.findViewById<ViewGroup>(R.id.linearLayoutPi)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizedMatchAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.xx_extra, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: OrganizedMatchAdapter.ViewHolder, position: Int) {

        val match: Match = matches[position]
        val userOrganaizer = allUsers.find{it.mail == match?.OrganaizerTeam}
        val textView2 = holder.textView2
        val textView4 = holder.textView4
        val textView6 = holder.textView6
        val profileImage = holder.profileImage
        val button = holder.button

        textView2.text = match.DayOfMatch
        textView6.text = match.LocationOfMatch
        textView4.text = match.HourOfMatch
        profileImage.setImageResource(userOrganaizer?.image!!)

        button.setOnClickListener {
            actionListener.goToMatchDetails(match)
        }
    }


    private fun matchType(match: Match): String {
        return match.javaClass.simpleName
    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return matches.size
    }

}