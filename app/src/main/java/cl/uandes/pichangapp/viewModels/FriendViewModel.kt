package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.FriendEntity
import cl.uandes.pichangapp.database.FriendRepository
import cl.uandes.pichangapp.database.FriendsDatabase
import cl.uandes.pichangapp.models.Friend
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FriendViewModel(application: Application): AndroidViewModel(application) {
    private val repository: FriendRepository
    private val allFriends: LiveData<List<FriendEntity>>

    init {
        val friendDao = FriendsDatabase.getDatabase(application).friendDao()
        repository = FriendRepository(friendDao)
        allFriends = repository.getAllFriends
    }

    fun addFriend(friend: FriendEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addFriend(friend)
        }
    }


}