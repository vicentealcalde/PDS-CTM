package cl.uandes.pichangapp

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.models.Match
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.viewModels.FriendViewModel

class MatchAdapter (
    private val actionListener: ActionListener,
    private val friendViewModel: FriendViewModel,
    private val apiViewModel: ApiViewModel
): RecyclerView.Adapter<MatchAdapter.ViewHolder>() {
    private var friends: List<FriendEntity> = emptyList()

    fun set(item: List<FriendEntity>){
        friends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!
        val buttonAccept = itemView.findViewById<View>(R.id.button_accept)!!
        val buttonReject = itemView.findViewById<View>(R.id.button_reject)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_accept_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: MatchAdapter.ViewHolder, position: Int) {

        val friend: FriendEntity = friends[position]
        val textView4 = holder.textView4
        val buttonAccept = holder.buttonAccept
        val buttonReject = holder.buttonReject
        textView4.text = friend.friendId.toString()


        buttonAccept.setOnClickListener {
            val myId: Int? = currentUser?.id?.toInt()
            if (myId != null) {
                // Status 1 to Accept, 0 to Reject Request
                friend.friendshipId?.let { it -> apiViewModel.acceptFriend(it.toInt(), 1)
                }
                friend.friendId?.let { it1 -> friendViewModel.deleteFriend(it1.toInt()) }
            }
        }

        buttonReject.setOnClickListener {
            val myId: Int? = currentUser?.id?.toInt()
            if (myId != null) {
                // Status 1 to Accept, 0 to Reject Request
                friend.friendshipId?.let { it1 -> apiViewModel.acceptFriend(it1.toInt(), 0) }
                friend.friendId?.let { it1 -> friendViewModel.deleteFriend(it1.toInt()) }
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