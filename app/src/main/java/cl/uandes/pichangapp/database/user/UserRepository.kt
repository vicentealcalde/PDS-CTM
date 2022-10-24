package cl.uandes.pichangapp.database.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    fun getNoFriends(): LiveData<List<UserEntity>>{
        return userDao.getAllUsers()
    }

    fun getUserName(id:Int): LiveData<String>{
        return userDao.getUserName(id)
    }

    suspend fun addUser(User: UserEntity){
        userDao.addUser(User)
    }

    fun deleteAllNoFriends(){
        userDao.deleteAllNoFriends()
    }

    suspend fun deleteNoFriend(userId: Int){
        userDao.deleteNoFriend(userId)
    }
}