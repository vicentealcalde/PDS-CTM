package cl.uandes.pichangapp.views.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.user.UserEntity
import cl.uandes.pichangapp.models.Lobby

class LobbyAdapter (
    private val actionListener: ActionListener
): RecyclerView.Adapter<LobbyAdapter.ViewHolder>() {
    private var lobbies: List<LobbyEntity> = emptyList()

    fun set(item: List<LobbyEntity>){
        lobbies = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!
        val textView2 = itemView.findViewById<TextView>(R.id.textView2)!!
        val button = itemView.findViewById<ViewGroup>(R.id.linearLayoutPi)!!
        //val button = itemView.findViewById<ViewGroup>(R.id.button_send)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LobbyAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expandgame, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder:LobbyAdapter.ViewHolder, position: Int) {

        val lobby: LobbyEntity = lobbies[position]
        val button = holder.button
        /*
        if (currentUser!!.id?.toInt() == lobby.current_user){
            button.background =
        }
         */
        val textView2 = holder.textView2
        //val profileImage = holder.profileImage

        textView2.text = lobby.LobbyId.toString()

    }


    private fun matchType(lobby: Lobby): String {
        return lobby.javaClass.simpleName
    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return lobbies.size
    }
}