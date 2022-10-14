package cl.uandes.pichangapp.database

interface EntityMapper<T, V> {
    fun mapFromCached(type: T): V
    fun mapToCached(type: V): T
}