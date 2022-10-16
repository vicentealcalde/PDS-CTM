package cl.uandes.pichangapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.uandes.pichangapp.database.Lobby.LobbyDao
import cl.uandes.pichangapp.database.Lobby.LobbyEntity
import cl.uandes.pichangapp.database.friend.FriendDao
import cl.uandes.pichangapp.database.friend.FriendEntity
import cl.uandes.pichangapp.database.user.UserDao
import cl.uandes.pichangapp.database.user.UserEntity

@Database(entities=[FriendEntity::class, UserEntity::class, LobbyEntity::class], version=1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun friendDao(): FriendDao
    abstract fun userDao(): UserDao
    abstract fun lobbyDao(): LobbyDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}