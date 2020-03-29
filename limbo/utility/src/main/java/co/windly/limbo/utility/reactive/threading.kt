package co.windly.limbo.utility.reactive

import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

/**
 * Calls given lambda on io-bound thread.
 */
fun io(lambda: () -> Unit): Completable =
  Completable
    .fromAction { lambda() }
    .subscribeOn(Schedulers.io())

/**
 * Calls given lambda on computation-bound thread.
 */
fun computation(lambda: () -> Unit): Completable =
  Completable
    .fromAction { lambda() }
    .subscribeOn(Schedulers.computation())

/**
 * Calls given lambda on FIFO manner queued thread.
 */
fun trampoline(lambda: () -> Unit): Completable =
  Completable
    .fromAction { lambda() }
    .subscribeOn(Schedulers.trampoline())

/**
 * Calls a given lambda on thread from which caller method has been invoked.
 */
fun immediate(lambda: () -> Unit): Completable =
  Completable
    .fromAction { lambda() }
