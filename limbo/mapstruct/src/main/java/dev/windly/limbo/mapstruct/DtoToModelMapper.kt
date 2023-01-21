package dev.windly.limbo.mapstruct

/**
 * Mixin that enables mapper to conform models mapping between
 * network and domain layers.
 */
interface DtoToModelMapper<Dto : Any, Model : Any> {

  fun mapDtoToDomain(dto: Dto): Model

  fun mapDtoListToDomainList(dtos: List<Dto>): List<Model>

  fun mapDomainToDto(model: Model): Dto

  fun mapDomainListToDtoList(models: List<Model>): List<Dto>
}
