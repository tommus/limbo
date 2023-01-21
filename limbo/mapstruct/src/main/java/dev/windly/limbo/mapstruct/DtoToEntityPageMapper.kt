package dev.windly.limbo.mapstruct

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
