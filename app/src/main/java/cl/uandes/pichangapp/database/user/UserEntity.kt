package cl.uandes.pichangapp.database.user

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "UsersTable")
@Parcelize
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    @ColumnInfo(name = "username")
    val username: String?,
    @ColumnInfo(name = "password")
    val password: String?,
    @ColumnInfo(name = "matches")
    val matches: Int
): Parcelable