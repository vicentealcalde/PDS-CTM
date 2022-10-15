package cl.uandes.pichangapp.database.Lobby

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName="LobbyTable")
@Parcelize
data class LobbyEntity(
    @PrimaryKey
    @ColumnInfo(name = "LobbyId") val LobbyId: Int,
    @ColumnInfo(name = "members") val members: String
): Parcelable