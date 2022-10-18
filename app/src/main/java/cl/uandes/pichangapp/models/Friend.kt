package cl.uandes.pichangapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend (
    var id: Long?,
    val sender: Long?,
    val receiver: Long?,
    val status: Int = 0

):Parcelable
