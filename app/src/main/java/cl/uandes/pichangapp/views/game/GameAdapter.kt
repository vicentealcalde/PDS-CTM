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
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerEntity
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer

class GameAdapter (
    private val actionListener: ActionListener,
    private val apiViewModel: ApiViewModel
): RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    private var friends: List<InGamePlayerEntity> = emptyList()

    fun set(item: List<InGamePlayerEntity>){
        friends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView2 = itemView.findViewById<TextView>(R.id.textView2)!!
        val textView1 = itemView.findViewById<TextView>(R.id.textView1)!!

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.users_with_dices, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: GameAdapter.ViewHolder, position: Int) {

        val friend: InGamePlayerEntity = friends[position]
        val textView1 = holder.textView1
        val textView2 = holder.textView2

        textView1.text = friend.user.toString()
        textView2.text = friend.dices.toString()





    }



    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

}
