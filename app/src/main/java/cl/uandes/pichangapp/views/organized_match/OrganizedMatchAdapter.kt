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
import cl.uandes.pichangapp.allUserMatches
import cl.uandes.pichangapp.myNotFriends

class OrganizedMatchAdapter (
    private val nofriends: MutableList<String>,
    private val actionListener: ActionListener
): RecyclerView.Adapter<OrganizedMatchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!


        val textView1 = itemView.findViewById<TextView>(R.id.textView1)!!

        //val button = itemView.findViewById<ViewGroup>(R.id.button_send)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizedMatchAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_add_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: OrganizedMatchAdapter.ViewHolder, position: Int) {

        val nofriend: String = nofriends[position]
        val textView1 = holder.textView1
        val profileImage = holder.profileImage
        //val button = holder.button
        textView1.text = nofriend

    }


    private fun matchType(match: Match): String {
        return match.javaClass.simpleName
    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return nofriends.size
    }

}