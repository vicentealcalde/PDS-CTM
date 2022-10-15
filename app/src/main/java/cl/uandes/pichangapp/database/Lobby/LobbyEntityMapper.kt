package cl.uandes.pichangapp.database.Lobby

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.Lobby

class LobbyEntityMapper: EntityMapper<LobbyEntity, Lobby> {
    override fun mapFromCached(type: LobbyEntity): Lobby {
        return Lobby(
            type.LobbyId,
            // Change members from string to List of Ints
            type.members.split(",").map{ it.toInt() }
        )
    }

    override fun mapToCached(type: Lobby): LobbyEntity {
        return LobbyEntity(
            type.lobbyId,
            // Change members from list of Ints to string
            type.members.joinToString()
        )
    }
}