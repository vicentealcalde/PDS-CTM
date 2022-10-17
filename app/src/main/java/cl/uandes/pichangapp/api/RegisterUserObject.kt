package cl.uandes.pichangapp.api

data class RegisterUserObject(
    val username: String,
    val password: String,
    val games: Int
)