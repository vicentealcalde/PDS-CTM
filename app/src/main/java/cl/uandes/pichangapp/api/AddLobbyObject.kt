package cl.uandes.pichangapp.api

// Similar to Lobby but to create a lobby in the API its necessary to not send an ID
data class AddLobbyObject (
    val status: Int,
    val dices_per_player: Int,
    val rounds: Int,
    val current_user: Int
)