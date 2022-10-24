package cl.uandes.pichangapp.database.InGamePlayer

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface InGamePlayerDao {
    @Query("Select * From InGamePlayersTable Where lobby = :lobbyId")
    fun getInGamePlayersFromLobby(lobbyId: Int): LiveData<List<InGamePlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addInGamePlayer(player: InGamePlayerEntity)

    @Query("DELETE FROM InGamePlayersTable WHERE id = :playerId")
    suspend fun deleteInGamePlayer(playerId: Int)
}