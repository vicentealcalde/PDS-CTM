package cl.uandes.pichangapp.database.friend

import androidx.lifecycle.LiveData


class FriendRepository(private val friendDao: FriendDao) {

    fun getAcceptedFriends(): LiveData<List<FriendEntity>> {
        return friendDao.getAcceptedFriends()
    }

    fun getFriendRequests(): LiveData<List<FriendEntity>>{
        return friendDao.getFriendRequests()
    }

    suspend fun addFriend(friend: FriendEntity){
        friendDao.addFriend(friend)
    }

    fun deleteAllFriends(){
        friendDao.deleteAllFriends()
    }
}