package co.windly.limbo.utility.mapping

//region Mapper

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence layer taking into account pagination-powered
 * network methods.
 */
abstract class TwoLayerPaginationMapper<Dto, Entity, Page : LimboPageDto<Dto>, Metadata : LimboPageMetadata> :
  DtoToEntityPageMapper<Page, Dto, Entity>(),
  PageMetadataMapper<Metadata, Dto>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence to domain layer.
 */
interface CleanCodeMapper<Dto, Entity, Model> :
  DtoToEntityMapper<Dto, Entity>,
  EntityToModelMapper<Entity, Model>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence to domain layer taking into account pagination-powered
 * network methods.
 */
abstract class CleanCodePaginationMapper<Dto, Entity, Model, Page : LimboPageDto<Dto>, Metadata : LimboPageMetadata> :
  DtoToEntityPageMapper<Page, Dto, Entity>(),
  EntityToModelMapper<Entity, Model>,
  PageMetadataMapper<Metadata, Dto>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence, network to domain, persistence to domain layer.
 */
interface ExtendedMapper<Dto, Entity, Model> :
  DtoToEntityMapper<Dto, Entity>,
  DtoToModelMapper<Dto, Model>,
  EntityToModelMapper<Entity, Model>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence, network to domain, persistence to domain layer
 * taking into account pagination-powered network methods.
 */
abstract class ExtendedPaginationMapper<Dto, Entity, Model, Page : LimboPageDto<Dto>, Metadata : LimboPageMetadata> :
  DtoToEntityPageMapper<Page, Dto, Entity>(),
  DtoToModelMapper<Dto, Model>,
  EntityToModelMapper<Entity, Model>,
  PageMetadataMapper<Metadata, Dto>

//endregion

//region Mixin

/**
 * Mixin that enables mapper to conform models mapping between
 * network and persistence layers.
 */
interface DtoToEntityMapper<Dto, Entity> {

  fun mapDtoToEntity(dto: Dto): Entity

  fun mapDtoListToEntityList(dtos: List<Dto>): List<Entity>
}

/**
 * Mixin that enables mapper to conform models mapping between
 * network and domain layers.
 */
interface DtoToModelMapper<Dto, Model> {

  //region Network -> Domain

  fun mapDtoToDomain(dto: Dto): Model

  fun mapDtoListToDomainList(dtos: List<Dto>): List<Model>

  //endregion

  //region Domain -> Network

  fun mapDomainToDto(model: Model): Dto

  fun mapDomainListToDtoList(models: List<Model>): List<Dto>

  //endregion
}

/**
 * Mixin that enables mapper to conform models mapping between
 * entity and domain layers.
 */
interface EntityToModelMapper<Entity, Model> {

  //region Entity -> Domain

  fun mapEntityToDomain(entity: Entity): Model

  fun mapEntityListToDomainList(entities: List<Entity>): List<Model>

  //endregion

  //region Domain -> Entity

  fun mapDomainToEntity(model: Model): Entity

  fun mapDomainListToEntityList(models: List<Model>): List<Entity>

  //endregion
}

//endregion

//region Pagination

/**
 * Class that is supposed to be extended to provide specific pagination-related
 * information. It should be a part of network layer.
 */
abstract class LimboPageDto<Dto> {

  abstract fun retrieveContent(): List<Dto>
}

/**
 * Class that is supposed to be extended to keep pagination-related metadata
 * (such as number of total elements, current page, page size, etc.). It should
 * be a part of domain layer.
 */
abstract class LimboPageMetadata

/**
 * Mixin that enables mapper to conform pagination-powered models
 * mapping between network and persistence layers.
 */
abstract class DtoToEntityPageMapper<Page : LimboPageDto<Dto>, Dto, Entity> :
  DtoToEntityMapper<Dto, Entity> {

  fun mapPageListDtoToEntityList(dto: Page): List<Entity> =
    mapDtoListToEntityList(dto.retrieveContent())
}

/**
 * Mixin that enables mapper to extract pagination metadata from network dto.
 */
interface PageMetadataMapper<Metadata : LimboPageMetadata, Dto> {

  fun mapPageListDtoToMetadata(dto: LimboPageDto<Dto>): Metadata
}

//endregion
