package cl.uandes.pichangapp.database.friend

import androidx.lifecycle.LiveData
import cl.uandes.pichangapp.database.friend.FriendDao
import cl.uandes.pichangapp.database.friend.FriendEntity


class FriendRepository(private val friendDao: FriendDao) {

    val getAllUserFriends: LiveData<List<FriendEntity>> = friendDao.getAllUserFriends()

    suspend fun addFriend(friend: FriendEntity){
        friendDao.addFriend(friend)
    }
}