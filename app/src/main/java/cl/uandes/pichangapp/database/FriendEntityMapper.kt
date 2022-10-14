package cl.uandes.pichangapp.database

import cl.uandes.pichangapp.models.Friend


class FriendEntityMapper: EntityMapper<FriendEntity, Friend> {
    override fun mapFromCached(type: FriendEntity): Friend {
        return Friend(
            type.id,
            type.name,
            type.status
        )
    }
    override fun mapToCached(type: Friend): FriendEntity {
        return FriendEntity(
            type.id,
            type.name,
            type.status
        )
    }
}