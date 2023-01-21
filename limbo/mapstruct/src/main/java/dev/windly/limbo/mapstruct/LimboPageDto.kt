package dev.windly.limbo.mapstruct

/**
 * Class that is supposed to be extended to provide specific pagination-related
 * information. It should be a part of network layer.
 */
abstract class LimboPageDto<Dto : Any> {

  abstract fun retrieveContent(): List<Dto>
}
