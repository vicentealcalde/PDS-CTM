package cl.uandes.pichangapp.database.userStats

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "UserStatsTable")
@Parcelize
data class UserStatsEntity (
    @PrimaryKey
    @ColumnInfo(name="user") val user: Int?,
    @ColumnInfo(name="losts") val losts: Int?,
    @ColumnInfo(name="nemesis") val nemesis: String?,
    @ColumnInfo(name="the_most") val the_most: Int?,
    @ColumnInfo(name="the_least") val the_least: Int?,
    @ColumnInfo(name="damage") val damage: Int?,
    @ColumnInfo(name="one") val one: Int?,
    @ColumnInfo(name="two") val two: Int?,
    @ColumnInfo(name="three") val three: Int?,
    @ColumnInfo(name="four") val four: Int?,
    @ColumnInfo(name="five") val five: Int?,
    @ColumnInfo(name="six") val six: Int?,
    @ColumnInfo(name="rounds_with_one") val rounds_with_one: Int?,

): Parcelable