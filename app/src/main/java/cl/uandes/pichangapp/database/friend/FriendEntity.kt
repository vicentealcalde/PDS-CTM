package cl.uandes.pichangapp.database.friend

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "FriendsTable")
@Parcelize
data class FriendEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    @ColumnInfo(name = "senderId")
    val id_sender: Int,
    @ColumnInfo(name = "receiverId")
    val id_receiver: Int,
    @ColumnInfo(name = "status")
    val status: Int
): Parcelable