package cl.uandes.pichangapp.database.userStats

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserStatsDao {
    @Query("Select * From UserStatsTable Limit 1")
    fun getUserStats(): LiveData<UserStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserStats(stats: UserStatsEntity)

    @Query("DELETE FROM UserStatsTable")
    suspend fun deleteAllStats()
}