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
import cl.uandes.pichangapp.R.drawable

import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerEntity
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.models.Friend
import cl.uandes.pichangapp.models.InGamePlayer



class ResultRollAdapter (
    private val actionListener: ActionListener,
    private val apiViewModel: ApiViewModel
): RecyclerView.Adapter<ResultRollAdapter.ViewHolder>() {
    private var friends: List<Int> = emptyList()

    fun set(item: List<Int>){
        friends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dice = itemView.findViewById<ImageView>(R.id.dice)!!


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultRollAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.users_with_dices, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: ResultRollAdapter.ViewHolder, position: Int) {

        var dice = holder.dice
        if ( friends[position] == 1 ){
            dice.setImageResource(R.drawable.dice_1)
        }

        if ( friends[position] == 2 ){
            dice.setImageResource(R.drawable.dice_2)
        }
        if ( friends[position] == 3 ){
            dice.setImageResource(R.drawable.dice_3)

        }
        if ( friends[position] == 4 ){
            dice.setImageResource(R.drawable.dice_4)

        }
        if ( friends[position] == 5  ){
            dice.setImageResource(R.drawable.dice_5)

        }
        if ( friends[position] == 6  ){
            dice.setImageResource(R.drawable.dice_6)

        }





    }



    interface ActionListener {
        fun goToMatchDetails(match: Match)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

}
