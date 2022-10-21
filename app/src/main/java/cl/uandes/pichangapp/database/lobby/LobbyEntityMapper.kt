package cl.uandes.pichangapp.database.lobby

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.Lobby

class LobbyEntityMapper: EntityMapper<LobbyEntity, Lobby> {
    override fun mapFromCached(type: LobbyEntity): Lobby {
        return Lobby(
            type.LobbyId,
            type.status,
            type.rounds,
            type.dices_per_player,
            type.current_user,
            //Change members from string to list of ints
            type.members.split(",").map { it.toInt() }
        )
    }

    override fun mapToCached(type: Lobby): LobbyEntity {
        return LobbyEntity(
            type.id,
            type.status,
            type.rounds,
            type.dices_per_player,
            type.current_user,
            //Change members from list of ints to string
            type.members.joinToString()
        )
    }
}