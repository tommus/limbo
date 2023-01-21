package dev.windly.limbo.mapstruct

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
