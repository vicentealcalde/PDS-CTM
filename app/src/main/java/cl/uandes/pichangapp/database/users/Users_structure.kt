package cl.uandes.pichangapp.database.users

import com.google.gson.annotations.SerializedName

data class Users_structure(
    @SerializedName("id")
    var id: Long?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("category")
    val category: String?
)
