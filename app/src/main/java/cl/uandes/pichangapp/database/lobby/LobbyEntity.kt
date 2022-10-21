package cl.uandes.pichangapp.database.lobby

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
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "rounds") val rounds: Int,
    @ColumnInfo(name = "dices_per_player") val dices_per_player: Int,
    @ColumnInfo(name = "current_user") val current_user: Int,
    @ColumnInfo(name = "members") val members: String
): Parcelable