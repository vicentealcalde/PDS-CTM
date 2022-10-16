package cl.uandes.pichangapp.database.users

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("users")
    val users: List<Users_structure>,
)

annotation class SerializedName(val value: String)
