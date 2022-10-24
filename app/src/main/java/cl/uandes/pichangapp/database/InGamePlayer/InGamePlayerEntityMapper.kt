package cl.uandes.pichangapp.database.InGamePlayer

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.InGamePlayer

class InGamePlayerEntityMapper: EntityMapper<InGamePlayer, InGamePlayerEntity> {
    override fun mapFromCached(type: InGamePlayer): InGamePlayerEntity {
        return InGamePlayerEntity(
            type.id,
            type.user,
            type.lobby,
            type.dices,
            type.status
        )
    }

    override fun mapToCached(type: InGamePlayerEntity): InGamePlayer {
        TODO("Not yet implemented")
    }
}