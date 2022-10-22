package cl.uandes.pichangapp.database.lobby

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.InGamePlayer
import cl.uandes.pichangapp.models.Lobby

class InGamePlayerToLobbyEntityMapper: EntityMapper<InGamePlayer, Lobby> {
    override fun mapFromCached(type: InGamePlayer): Lobby {
        return Lobby(
            type.lobby,
            -1,
            0,
            type.dices,
            0,
            emptyList()
        )
    }

    override fun mapToCached(type: Lobby): InGamePlayer {
        TODO("Not yet implemented")
    }
}