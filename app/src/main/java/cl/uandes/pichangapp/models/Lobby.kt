package cl.uandes.pichangapp.models

data class Lobby (
    val id: Int,
    val status: Int,
    val rounds: Int,
    val dices_per_player: Int,
    val current_user: Int,
    val members: List<Int>,
)