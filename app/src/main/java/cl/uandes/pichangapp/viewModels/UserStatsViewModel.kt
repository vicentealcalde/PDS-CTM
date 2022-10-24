package cl.uandes.pichangapp.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.uandes.pichangapp.database.lobby.LobbyRepository
import cl.uandes.pichangapp.database.userStats.UserStatsEntity
import cl.uandes.pichangapp.database.userStats.UserStatsRepository
import kotlinx.coroutines.launch

class UserStatsViewModel(application: Application, private val repository: UserStatsRepository): AndroidViewModel(application) {

    fun getUserStats(): LiveData<UserStatsEntity> {
        return repository.getUserStats()
    }

    fun addUserStats(stats: UserStatsEntity){
        viewModelScope.launch {
            repository.addUserStats(stats)
        }
    }
    fun deleteAllStats(){
        viewModelScope.launch {
            repository.deleteAllStats()
        }
    }
}