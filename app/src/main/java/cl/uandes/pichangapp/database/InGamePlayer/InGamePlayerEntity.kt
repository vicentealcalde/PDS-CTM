package cl.uandes.pichangapp.database.InGamePlayer

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "InGamePlayersTable")
@Parcelize
data class InGamePlayerEntity (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "user") val user: Int,
    @ColumnInfo(name = "lobby") val lobby: Int,
    @ColumnInfo(name = "dices") val dices: Int,
    @ColumnInfo(name = "status") val status: Int,
): Parcelable