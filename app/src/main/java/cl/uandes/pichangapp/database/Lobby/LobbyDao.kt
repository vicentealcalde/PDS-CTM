package cl.uandes.pichangapp.database.Lobby

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LobbyDao {
    @Query("SELECT * FROM LobbyTable")
    fun getUserLobbies(): LiveData<List<LobbyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLobby(lobby: LobbyEntity)

    @Query("DELETE FROM LobbyTable")
    suspend fun deleteAllLobbies()

    @Query("DELETE FROM LobbyTable WHERE LobbyId = :id")
    suspend fun deleteLobby(id: Int)
}