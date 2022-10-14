package cl.uandes.pichangapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend (
    val id: Int,
    val name: String,
    val status: Int
):Parcelable
