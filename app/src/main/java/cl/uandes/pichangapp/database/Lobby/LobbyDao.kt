package cl.uandes.pichangapp.database.Lobby

import androidx.lifecycle.LiveData
import androidx.room.*
import cl.uandes.pichangapp.database.FriendEntity

@Dao
interface LobbyDao {
    @Query("SELECT * FROM LobbyTable")
    fun getAllLobbys(): LiveData<List<LobbyEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLobby(lobby: LobbyEntity)
}