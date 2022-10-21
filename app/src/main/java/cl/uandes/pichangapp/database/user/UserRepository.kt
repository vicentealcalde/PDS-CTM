package cl.uandes.pichangapp.database.user

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    fun getNoFriends(): LiveData<List<UserEntity>>{
        return userDao.getAllUsers()
    }

    suspend fun addUser(User: UserEntity){
        userDao.addUser(User)
    }

    fun deleteAllNoFriends(){
        userDao.deleteAllNoFriends()
    }
}