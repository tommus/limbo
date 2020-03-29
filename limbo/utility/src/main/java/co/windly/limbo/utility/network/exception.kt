package co.windly.limbo.utility.network

//region General

/**
 * Should be used as a base class for all network errors.
 */
abstract class NetworkException : RuntimeException {
  constructor() : super()
  constructor(message: String?) : super(message)
  constructor(cause: Throwable?) : super(cause)
}

/**
 * Should be raised when device is not connected to the internet.
 */
class NoNetworkException : NetworkException {
  constructor() : super()
  constructor(message: String?) : super(message)
  constructor(cause: Throwable?) : super(cause)
}

/**
 * Should be raised when device is not able to reach the server.
 */
class NoServerException : NetworkException {
  constructor() : super()
  constructor(message: String?) : super(message)
  constructor(cause: Throwable?) : super(cause)
}

/**
 * Should be raised when unknown but network-related error occurred.
 */
class UnknownException : NetworkException {
  constructor() : super()
  constructor(message: String?) : super(message)
  constructor(cause: Throwable?) : super(cause)
}

//endregion
