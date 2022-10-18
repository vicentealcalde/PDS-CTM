package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.database.friend.FriendRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


class FriendViewModel(application: Application, private val repository: FriendRepository): AndroidViewModel(application) {

    var friends= mutableListOf<FriendEntity>()
    var friendRequests = mutableListOf<FriendEntity>()
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    fun getAcceptedFriends(){
        friends.clear()
        repository.getAcceptedFriends().forEach{
            friends.add(it)
        }
    }

    fun getFriendRequests(){
        friendRequests.clear()
        repository.getFriendRequests().forEach{
            friendRequests.add(it)
        }
    }


    fun addFriend(friend: FriendEntity){
        viewModelScope.launch(Dispatchers.IO) {
            //repository.addFriend(friend)
        }
    }





}