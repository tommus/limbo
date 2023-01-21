package dev.windly.limbo.mapstruct

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
