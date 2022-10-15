package cl.uandes.pichangapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    var id: Long?,
    val username: String?,
    val password: String?,
    val matches: Int = 0
):Parcelable




