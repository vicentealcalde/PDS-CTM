package cl.uandes.pichangapp.database.friend

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.Friend


class FriendEntityMapper: EntityMapper<FriendEntity, Friend> {
    override fun mapFromCached(type: FriendEntity): Friend {
        return Friend(
            type.id,
            type.id_sender,
            type.id_receiver,
            type.status
        )
    }
    override fun mapToCached(type: Friend): FriendEntity {
        return FriendEntity(
            type.id,
            type.id_sender,
            type.id_receiver,
            type.status
        )
    }
}