package cl.uandes.pichangapp.database.friend

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "FriendsTable")
@Parcelize
data class FriendEntity (
    @PrimaryKey
    @ColumnInfo(name = "friendId")
    val friendId: Long?,
    @ColumnInfo(name = "friendName")
    val friendName: String?,
    @ColumnInfo(name = "status")
    val status: Int
): Parcelable