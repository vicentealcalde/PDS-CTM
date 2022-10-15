package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.database.friend.FriendRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FriendViewModel(application: Application): AndroidViewModel(application) {
    private val repository: FriendRepository
    private val userFriends: LiveData<List<FriendEntity>>

    init {
        val friendDao = AppDatabase.getDatabase(application).friendDao()
        repository = FriendRepository(friendDao)
        userFriends = repository.getAllUserFriends
    }

    fun addFriend(friend: FriendEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFriend(friend)
        }
    }

    fun debugAddFriends(){
         val debugFriends = listOf<FriendEntity>(
             FriendEntity(0,1, 2, 0),
             FriendEntity(0,1, 3, 0),
             FriendEntity(0,2, 3, 0),
             FriendEntity(0,2, 4, 0),
         )
        debugFriends.forEach{
            addFriend(it)
        }
    }


}