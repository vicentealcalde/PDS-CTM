package cl.uandes.pichangapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend (
    var id: Long?,
    val id_sender: Int,
    val id_receiver: Int,
    val status: Int = 0

):Parcelable
