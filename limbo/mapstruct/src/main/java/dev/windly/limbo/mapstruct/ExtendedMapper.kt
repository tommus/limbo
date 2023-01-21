package dev.windly.limbo.mapstruct

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence, network to domain, persistence to domain layer.
 */
interface ExtendedMapper<Dto : Any, Entity : Any, Model : Any> :
  DtoToEntityMapper<Dto, Entity>,
  DtoToModelMapper<Dto, Model>,
  EntityToModelMapper<Entity, Model>
