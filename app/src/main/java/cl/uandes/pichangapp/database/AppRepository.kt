package cl.uandes.pichangapp.database

import cl.uandes.pichangapp.database.InGamePlayer.InGamePlayerDao
import cl.uandes.pichangapp.database.friend.FriendDao
import cl.uandes.pichangapp.database.lobby.LobbyDao
import cl.uandes.pichangapp.database.user.UserDao
import cl.uandes.pichangapp.database.userStats.UserStatsDao


class AppRepository(private val database: AppDatabase) {

    fun getFriendDao(): FriendDao {
        return database.friendDao()
    }
    fun getLobbyDao(): LobbyDao {
        return database.lobbyDao()
    }
    fun getUserDao(): UserDao {
        return database.userDao()
    }
    fun getInGamePlayerDao(): InGamePlayerDao {
        return database.inGamePlayerDao()
    }
    fun getUserStatsDao(): UserStatsDao {
        return database.userStatsDao()
    }
}