package cl.uandes.pichangapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[FriendEntity::class], version=1, exportSchema = false)
abstract class FriendsDatabase: RoomDatabase() {
    abstract fun friendDao(): FriendDao

    companion object{
        @Volatile
        private var INSTANCE: FriendsDatabase? = null

        fun getDatabase(context: Context): FriendsDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FriendsDatabase::class.java,
                    "friends_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}