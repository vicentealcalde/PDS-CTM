package cl.uandes.pichangapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.models.Friend

class MatchAdapter (
    private val friends: MutableList<Friend>,
    private val actionListener: ActionListener
): RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!

        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!

        val button = itemView.findViewById<ViewGroup>(R.id.button_send)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_accept_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {

        val friend: Friend = friends[position]
        val textView4 = holder.textView4
        val profileImage = holder.profileImage
        val button = holder.button
        textView4.text = friend.id.toString()


        button.setOnClickListener {

        }
    }



    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

}