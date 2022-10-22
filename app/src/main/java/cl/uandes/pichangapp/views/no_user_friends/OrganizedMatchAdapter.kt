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
import cl.uandes.pichangapp.api.ApiViewModel
import cl.uandes.pichangapp.currentUser
import cl.uandes.pichangapp.database.user.UserEntity

class OrganizedMatchAdapter (
    private val apiViewModel: ApiViewModel,
    private val actionListener: ActionListener
): RecyclerView.Adapter<OrganizedMatchAdapter.ViewHolder>() {
    private var nofriends: List<UserEntity> = emptyList()

    fun set(item: List<UserEntity>){
        nofriends = item
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)!!


        val textView4 = itemView.findViewById<TextView>(R.id.textView4)!!

        val button = itemView.findViewById<View>(R.id.button_send)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizedMatchAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val resultView: View = inflater.inflate(R.layout.expand_add_friend, parent, false)
        return ViewHolder(resultView)
    }

    override fun onBindViewHolder(holder: OrganizedMatchAdapter.ViewHolder, position: Int) {

        val nofriend: UserEntity = nofriends[position]
        val textView4 = holder.textView4
        val profileImage = holder.profileImage
        val button = holder.button
        textView4.text = nofriend.username

        button.setOnClickListener {
            val myId: Int? = currentUser?.id?.toInt()
            if (myId != null) {
                nofriend.id?.let { it1 -> apiViewModel.addFriend(myId,it1.toInt(),0) }
            }
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