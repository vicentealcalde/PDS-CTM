package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.lobby.LobbyDao
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.lobby.LobbyRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LobbyViewModel(application: Application, private val repository: LobbyRepository): AndroidViewModel(application) {

    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    fun getUserLobbies(): LiveData<List<LobbyEntity>> {
        return repository.getUserLobbies()
    }
    fun deleteLobby(lobbyId: Int){
        return repository.deleteLobby(lobbyId)
    }

    fun deleteAllLobbies(){
        return repository.deleteAllLobbies()
    }


}