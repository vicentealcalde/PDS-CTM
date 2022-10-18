package cl.uandes.pichangapp.database.friend


class FriendRepository(private val friendDao: FriendDao) {

    fun getAcceptedFriends(): List<FriendEntity> {
        return friendDao.getAcceptedFriends()
    }

    fun getFriendRequests(): List<FriendEntity>{
        return friendDao.getFriendRequests()
    }

    suspend fun addFriend(friend: FriendEntity){
        friendDao.addFriend(friend)
    }

    suspend fun deleteAllFriends(){
        friendDao.deleteAllFriends()
    }
}