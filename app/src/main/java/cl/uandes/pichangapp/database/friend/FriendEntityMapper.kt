package cl.uandes.pichangapp.database.friend

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.Friend


class FriendEntityMapper: EntityMapper<FriendEntity, Friend> {
    override fun mapFromCached(type: FriendEntity): Friend {
        TODO("Not yet implemented")
    }
    override fun mapToCached(type: Friend): FriendEntity {
        return FriendEntity(
            type.sender,
            "",
            0,
            type.id
        )
    }
}