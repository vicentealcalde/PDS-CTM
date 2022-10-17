package cl.uandes.pichangapp.database.lobby

import androidx.lifecycle.LiveData

class LobbyRepository(private val lobbyDao: LobbyDao) {

    val getUserLobbies: LiveData<List<LobbyEntity>> = lobbyDao.getUserLobbies()

    suspend fun addLobby(lobby: LobbyEntity){
        lobbyDao.addLobby(lobby)
    }

    suspend fun deleteLobby(lobbyId: Int){
        lobbyDao.deleteLobby(lobbyId)
    }

    suspend fun deleteAllLobbies(){
        lobbyDao.deleteAllLobbies()
    }

}