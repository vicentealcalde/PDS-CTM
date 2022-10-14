package cl.uandes.pichangapp.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "FriendsTable")
@Parcelize
data class FriendEntity (
    @PrimaryKey
    @ColumnInfo(name = "friendId") val id: Int,
    @ColumnInfo(name = "friendName") val name: String,
    @ColumnInfo(name = "status") val status: Int
): Parcelable