package cl.uandes.pichangapp.database.friend

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FriendDao {
    @Query("SELECT * FROM FriendsTable")
    fun getAllUserFriends(): LiveData<List<FriendEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFriend(friend: FriendEntity)
}