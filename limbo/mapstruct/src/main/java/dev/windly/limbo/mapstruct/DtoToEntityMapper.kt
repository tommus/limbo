package dev.windly.limbo.mapstruct

/**
 * Mixin that enables mapper to conform models mapping between
 * network and persistence layers.
 */
interface DtoToEntityMapper<Dto : Any, Entity : Any> {

  fun mapDtoToEntity(dto: Dto): Entity

  fun mapDtoListToEntityList(dtos: List<Dto>): List<Entity>
}
