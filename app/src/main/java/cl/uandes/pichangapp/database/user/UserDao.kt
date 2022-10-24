package cl.uandes.pichangapp.database.user

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM UsersTable")
    fun getAllUsers(): LiveData<List<UserEntity>>

    @Query("SELECT username FROM UsersTable Where id = :userId")
    fun getUserName(userId: Int): LiveData<String>

    @Query("Delete from UsersTable")
    fun deleteAllNoFriends()

    @Query("DELETE FROM UsersTable Where id = :userId")
    suspend fun deleteNoFriend(userId: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserEntity)
}