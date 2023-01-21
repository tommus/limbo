package dev.windly.limbo.mapstruct

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence to domain layer.
 */
interface CleanCodeMapper<Dto : Any, Entity : Any, Model : Any> :
  DtoToEntityMapper<Dto, Entity>,
  EntityToModelMapper<Entity, Model>
