package cl.uandes.pichangapp.database.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM UsersTable")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM UsersTable WHERE userName = :userName AND password = :password")
    fun login(userName:String, password:String): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserEntity)
}