package cl.uandes.pichangapp.database.userStats

import androidx.lifecycle.LiveData

class UserStatsRepository(private val userStatsDao: UserStatsDao) {

    fun getUserStats(): LiveData<UserStatsEntity> {
        return userStatsDao.getUserStats()
    }

    suspend fun addUserStats(stats: UserStatsEntity){
        return userStatsDao.addUserStats(stats)
    }

    suspend fun deleteAllStats(){
        return userStatsDao.deleteAllStats()
    }
}