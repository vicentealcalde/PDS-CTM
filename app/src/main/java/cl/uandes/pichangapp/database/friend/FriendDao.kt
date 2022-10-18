package cl.uandes.pichangapp.database.friend

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendDao {
    @Query("SELECT * FROM FriendsTable WHERE status = 3")
    fun getAcceptedFriends(): List<FriendEntity>

    @Query("SELECT * FROM FriendsTable WHERE status = 0")
    fun getFriendRequests(): List<FriendEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFriend(friend: FriendEntity)

    @Query("DELETE FROM FriendsTable")
    fun deleteAllFriends()

}