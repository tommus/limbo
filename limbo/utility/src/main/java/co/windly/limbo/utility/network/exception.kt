package co.windly.limbo.utility.network

//region General

/**
 * Base class for all network errors.
 */
abstract class NetworkException(error: Throwable) : RuntimeException(error)

/**
 * Raised when device is not connected to the internet.
 */
class NoNetworkException(error: Throwable) : NetworkException(error)

/**
 * Raised when device is not able to reach the server.
 */
class NoServerException(error: Throwable) : NetworkException(error)

//endregion
