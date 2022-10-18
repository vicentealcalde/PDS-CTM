package cl.uandes.pichangapp.database.friend

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.database.user.UserEntity

class UserToFriendEntityMapper: EntityMapper<UserEntity, FriendEntity> {
    override fun mapFromCached(type: UserEntity): FriendEntity {
        return FriendEntity(
            type.id,
            type.username,
            3
        )
    }

    override fun mapToCached(type: FriendEntity): UserEntity {
        TODO("Not yet implemented")
    }
}