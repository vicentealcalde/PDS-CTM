package cl.uandes.pichangapp.database.InGamePlayer

import androidx.lifecycle.LiveData
import cl.uandes.pichangapp.models.InGamePlayer

class InGamePlayerRepository(private val inGamePlayerDao: InGamePlayerDao) {

    fun getInGamePlayersFromLobby(lobbyId: Int): LiveData<List<InGamePlayerEntity>> {
        return inGamePlayerDao.getInGamePlayersFromLobby(lobbyId)
    }
    suspend fun addInGamePlayer(inGamePlayer: InGamePlayerEntity){
        return inGamePlayerDao.addInGamePlayer(inGamePlayer)
    }
    suspend fun deleteInGamePlayer(playerId: Int){
        return inGamePlayerDao.deleteInGamePlayer(playerId)
    }
    suspend fun deleteAllPlayers(){
        return inGamePlayerDao.deleteAllPlayers()
    }
}