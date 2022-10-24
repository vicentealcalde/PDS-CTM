package cl.uandes.pichangapp.views.lobbies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.R
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.models.Match

class FriendAdapter (
    private val actionListener: ActionListener
): RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    private var friends: List<FriendEntity> = emptyList()

    fun set(item: List<FriendEntity>){
        friends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!

        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!


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
        val profileImage = holder.profileImage
        textView4.text = friend.friendName



    }

    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

}
