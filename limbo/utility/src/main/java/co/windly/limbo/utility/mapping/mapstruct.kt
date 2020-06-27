package co.windly.limbo.utility.mapping

//region Mapper

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence layer taking into account pagination-powered
 * network methods.
 */
abstract class TwoLayerPaginationMapper<
  Dto : Any,
  Entity : Any,
  PageDto : LimboPageDto<Dto>,
  Metadata : LimboPageMetadata<Next>,
  Next : Any> :
  DtoToEntityPageMapper<PageDto, Dto, Entity>(),
  PageMetadataMapper<PageDto, Metadata, Next, Dto>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence to domain layer.
 */
interface CleanCodeMapper<Dto : Any, Entity : Any, Model : Any> :
  DtoToEntityMapper<Dto, Entity>,
  EntityToModelMapper<Entity, Model>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence to domain layer taking into account pagination-powered
 * network methods.
 */
abstract class CleanCodePaginationMapper<
  Dto : Any,
  Entity : Any,
  Model : Any,
  PageDto : LimboPageDto<Dto>,
  Metadata : LimboPageMetadata<Next>,
  Next : Any> :
  DtoToEntityPageMapper<PageDto, Dto, Entity>(),
  EntityToModelMapper<Entity, Model>,
  PageMetadataMapper<PageDto, Metadata, Next, Dto>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence, network to domain, persistence to domain layer.
 */
interface ExtendedMapper<Dto : Any, Entity : Any, Model : Any> :
  DtoToEntityMapper<Dto, Entity>,
  DtoToModelMapper<Dto, Model>,
  EntityToModelMapper<Entity, Model>

/**
 * Aggregates a collection of mixins to conform models mapping from
 * network to persistence, network to domain, persistence to domain layer
 * taking into account pagination-powered network methods.
 */
abstract class ExtendedPaginationMapper<
  Dto : Any,
  Entity : Any,
  Model : Any,
  PageDto : LimboPageDto<Dto>,
  Metadata : LimboPageMetadata<Next>,
  Next : Any> :
  DtoToEntityPageMapper<PageDto, Dto, Entity>(),
  DtoToModelMapper<Dto, Model>,
  EntityToModelMapper<Entity, Model>,
  PageMetadataMapper<PageDto, Metadata, Next, Dto>

//endregion

//region Mixin

/**
 * Mixin that enables mapper to conform models mapping between
 * network and persistence layers.
 */
interface DtoToEntityMapper<Dto : Any, Entity : Any> {

  fun mapDtoToEntity(dto: Dto): Entity

  fun mapDtoListToEntityList(dtos: List<Dto>): List<Entity>
}

/**
 * Mixin that enables mapper to conform models mapping between
 * network and domain layers.
 */
interface DtoToModelMapper<Dto : Any, Model : Any> {

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
interface EntityToModelMapper<Entity : Any, Model : Any> {

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
abstract class LimboPageDto<Dto : Any> {

  abstract fun retrieveContent(): List<Dto>
}

/**
 * Class that is supposed to be extended to keep pagination-related metadata
 * (such as number of total elements, current page, page size, etc.). It should
 * be a part of domain layer.
 */
abstract class LimboPageMetadata<Next : Any> {

  /**
   * Provides and information whether next page is available.
   */
  abstract val isNextAvailable: Boolean

  /**
   * Identifies next page (usually it's page number, next page token, etc.).
   */
  abstract val nextIdentifier: Next
}

/**
 * Mixin that enables mapper to conform pagination-powered models
 * mapping between network and persistence layers.
 */
abstract class DtoToEntityPageMapper<
  PageDto : LimboPageDto<Dto>,
  Dto : Any,
  Entity : Any> :
  DtoToEntityMapper<Dto, Entity> {

  fun mapPageListDtoToEntityList(dto: PageDto): List<Entity> =
    mapDtoListToEntityList(dto.retrieveContent())
}

/**
 * Mixin that enables mapper to extract pagination metadata from network dto.
 */
interface PageMetadataMapper<
  PageDto : LimboPageDto<Dto>,
  Metadata : LimboPageMetadata<Next>,
  Next : Any,
  Dto : Any> {

  fun mapPageListDtoToMetadata(dto: PageDto): Metadata
}

//endregion
