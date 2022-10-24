package cl.uandes.pichangapp.database.userStats

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserStatsDao {
    @Query("Select * From UserStatsTable")
    fun getUserStats(): LiveData<List<UserStatsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserStats(stats: UserStatsEntity)

    @Query("DELETE FROM UserStatsTable")
    suspend fun deleteAllStats()
}