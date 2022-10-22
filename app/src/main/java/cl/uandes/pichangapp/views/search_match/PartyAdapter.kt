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
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity

class PartyAdapter (
    private val actionListener: ActionListener
): RecyclerView.Adapter<PartyAdapter.ViewHolder>() {
    private var nofriends: List<UserEntity> = emptyList()

    fun set(item: List<UserEntity>){
        nofriends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!
        val textView2 = itemView.findViewById<TextView>(R.id.textView2)!!
        val button = itemView.findViewById<ViewGroup>(R.id.linearLayoutPi)!!
        //val button = itemView.findViewById<ViewGroup>(R.id.button_send)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartyAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expandgame, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder:PartyAdapter.ViewHolder, position: Int) {

        //val data: LobbyEntity = nofriends[position]
        val textView2 = holder.textView2
        //val profileImage = holder.profileImage
        val button = holder.button
        //val button = holder.button
        //textView4.text = nofriend.username

    }


    private fun matchType(lobby: Lobby): String {
        return lobby.javaClass.simpleName
    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return nofriends.size
    }



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