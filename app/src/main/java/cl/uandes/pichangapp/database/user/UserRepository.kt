package cl.uandes.pichangapp.database.user

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

class UsersRepository(private val userDao: UserDao) {

    val getAllUsers: LiveData<List<UserEntity>> = userDao.getAllUsers()

    suspend fun addUser(User: UserEntity){
        userDao.addUser(User)
    }

    suspend fun getLogin(usersName:String, password:String){
        userDao.login(usersName, password)
    }
}