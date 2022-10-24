package cl.uandes.pichangapp.database.userStats

import cl.uandes.pichangapp.database.EntityMapper
import cl.uandes.pichangapp.models.UserStats

class UserStatsEntityMapper: EntityMapper<UserStats, UserStatsEntity> {
    override fun mapFromCached(type: UserStats): UserStatsEntity {
        return UserStatsEntity(
            type.user,
            type.losts,
            type.nemesis,
            type.the_most,
            type.the_least,
            type.damage,
            type.one,
            type.two,
            type.three,
            type.four,
            type.five,
            type.six,
            type.rounds_with_one
        )
    }

    override fun mapToCached(type: UserStatsEntity): UserStats {
        TODO("Not yet implemented")
    }
}