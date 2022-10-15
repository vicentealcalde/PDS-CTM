package cl.uandes.pichangapp.database.user

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.User

class UserEntityMapper: EntityMapper<UserEntity, User> {
    override fun mapFromCached(type: UserEntity): User {
        return User(
            type.id,
            type.username,
            type.password,
            type.matches
        )
    }

    override fun mapToCached(type: User): UserEntity {
        return UserEntity(
            type.id,
            type.username,
            type.password,
            type.matches
        )
    }
}



/*
class UserEntityMapper: EntityMapper<UserEntity, User> {
    override fun mapFromCached(type: UserEntity): User {
        return User(
            type.id,
            type.id_sender,
            type.id_receiver,
            type.status
        )
    }
    override fun mapToCached(type: User): UserEntity {
        return UserEntity(
            type.id,
            type.id_sender,
            type.id_receiver,
            type.status
        )
    }
}
*/