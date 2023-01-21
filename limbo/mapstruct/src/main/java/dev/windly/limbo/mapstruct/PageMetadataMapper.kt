package dev.windly.limbo.mapstruct

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
