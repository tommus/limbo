package dev.windly.limbo.mapstruct

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
