package dev.windly.limbo.mapstruct

/**
 * Mixin that enables mapper to conform models mapping between
 * entity and domain layers.
 */
interface EntityToModelMapper<Entity : Any, Model : Any> {

  fun mapEntityToDomain(entity: Entity): Model

  fun mapEntityListToDomainList(entities: List<Entity>): List<Model>

  fun mapDomainToEntity(model: Model): Entity

  fun mapDomainListToEntityList(models: List<Model>): List<Entity>
}
