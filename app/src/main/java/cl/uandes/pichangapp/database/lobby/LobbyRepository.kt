package cl.uandes.pichangapp.database.lobby

import androidx.lifecycle.LiveData

class LobbyRepository(private val lobbyDao: LobbyDao) {



    fun getUserLobbies(): LiveData<List<LobbyEntity>>{
        return lobbyDao.getUserLobbies()
    }

    suspend fun addLobby(lobby: LobbyEntity){
        lobbyDao.addLobby(lobby)
    }

    suspend fun deleteLobby(lobbyId: Int){
        lobbyDao.deleteLobby(lobbyId)
    }

    fun deleteAllLobbies(){
        lobbyDao.deleteAllLobbies()
    }

}