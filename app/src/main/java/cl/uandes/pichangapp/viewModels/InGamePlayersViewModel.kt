package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerEntity
import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class InGamePlayersViewModel(application: Application, private val repository: InGamePlayerRepository):
    AndroidViewModel(application) {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    fun getInGamePlayersFromLobby(lobbyId: Int): LiveData<List<InGamePlayerEntity>> {
        return repository.getInGamePlayersFromLobby(lobbyId)
    }
}