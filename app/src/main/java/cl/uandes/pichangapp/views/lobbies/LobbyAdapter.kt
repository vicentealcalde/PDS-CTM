package cl.uandes.pichangapp.views.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.R
import androidx.navigation.fragment.findNavController
import cl.uandes.pichangapp.currentLobby
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.database.lobby.LobbyEntity
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

        if (lobby.status == -1){
            button.setBackgroundColor(Color.parseColor("#AEAEAE"))
        }
        if (lobby.status == 2){
            if (lobby.current_user == currentUser!!.id?.toInt()){
                button.setBackgroundColor(Color.parseColor("#AEAEAE"))
            }
            else{
                button.setBackgroundColor(Color.parseColor("#0E86D4"))
            }
        }

        val textView2 = holder.textView2
        //val profileImage = holder.profileImage

        textView2.text = lobby.id.toString()

        button.setOnClickListener {
            currentLobby = lobby
            if (currentLobby!!.status == 0){
                actionListener.goToGameDetails(lobby.id)
            }
            if (currentLobby!!.status == 1){
                actionListener.goToStartedMatch(lobby.id)
            }


        }

    }


    private fun matchType(lobby: Lobby): String {
        return lobby.javaClass.simpleName
    }

    interface ActionListener {
        fun goToGameDetails(lobby: Int)
        fun goToStartedMatch(id: Int)
    }

    override fun getItemCount(): Int {
        return lobbies.size
    }
}