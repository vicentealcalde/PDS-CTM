package cl.uandes.pichangapp.views.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.uandes.pichangapp.database.AppDatabase
import cl.uandes.pichangapp.database.lobby.LobbyEntity
import cl.uandes.pichangapp.database.lobby.LobbyRepository

class LobbyViewModel(application: Application): AndroidViewModel(application) {
    private val repository: LobbyRepository
    private val userLobbies: LiveData<List<LobbyEntity>>

    init {
        val lobbyDao = AppDatabase.getDatabase(application).lobbyDao()
        repository = LobbyRepository(lobbyDao)
        userLobbies = repository.getUserLobbies
    }


}