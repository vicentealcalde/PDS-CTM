package cl.uandes.pichangapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.models.Match

class ResultItemAdapter (
    private val friends: List<FriendEntity>,
    private val actionListener: ActionListener
): RecyclerView.Adapter<ResultItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!

        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_delete_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: ResultItemAdapter.ViewHolder, position: Int) {

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
