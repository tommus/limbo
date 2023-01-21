package dev.windly.limbo.mapstruct

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
