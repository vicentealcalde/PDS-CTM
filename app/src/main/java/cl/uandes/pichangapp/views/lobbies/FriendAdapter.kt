package cl.uandes.pichangapp.views.lobbies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.currentLobby
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.models.Match

class FriendAdapter (
    private val actionListener: ActionListener,
    private val apiViewModel: ApiViewModel,
): RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    private var friends: List<FriendEntity> = emptyList()

    fun set(item: List<FriendEntity>){
        friends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!
        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!
        val button_send = itemView.findViewById<ImageButton>(R.id.button_send)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_add_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: FriendAdapter.ViewHolder, position: Int) {

        val friend: FriendEntity = friends[position]


        val textView4 = holder.textView4
        val button_send = holder.button_send
        textView4.text = friend.friendName

        button_send.setOnClickListener {
            friend.friendId?.let { it1 ->
                currentLobby?.let { it2 -> apiViewModel.createUserIGP(it1.toInt(), it2) }
            }
        }
    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

}
