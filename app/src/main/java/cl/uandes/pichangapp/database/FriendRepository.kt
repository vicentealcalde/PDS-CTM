package cl.uandes.pichangapp.database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


class FriendRepository(private val friendDao: FriendDao) {

    val getAllFriends: LiveData<List<FriendEntity>> = friendDao.getAllFriends()

    suspend fun addFriend(friend: FriendEntity){
        friendDao.addFriend(friend)
    }
}