package cl.uandes.pichangapp.database

import cl.uandes.pichangapp.database.friend.FriendDao
import cl.uandes.pichangapp.database.lobby.LobbyDao
import cl.uandes.pichangapp.database.user.UserDao


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
}