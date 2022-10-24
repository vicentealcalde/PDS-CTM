package cl.uandes.pichangapp.database.lobby

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LobbyDao {
    @Query("SELECT * FROM LobbyTable")
    fun getUserLobbies(): LiveData<List<LobbyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addLobby(lobby: LobbyEntity)

    @Query("DELETE FROM LobbyTable")
    fun deleteAllLobbies()

    @Query("DELETE FROM LobbyTable WHERE id = :id")
    fun deleteLobby(id: Int)
}