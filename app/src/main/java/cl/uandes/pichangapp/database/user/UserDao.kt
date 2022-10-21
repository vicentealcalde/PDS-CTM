package cl.uandes.pichangapp.database.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM UsersTable")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("DELETE FROM UsersTable")
    fun deleteAllNoFriends()

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserEntity)
}