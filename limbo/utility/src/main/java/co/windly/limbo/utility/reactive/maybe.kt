package co.windly.limbo.utility.reactive

import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.schedulers.Schedulers

/**
 * Immediately subscribes maybe and adds to a DisposableContainer.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna
 * throw an error.
 */
fun <T : Any> Maybe<T>.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe()
    .apply { composite.add(this) }

/**
 * Immediately subscribes maybe and adds to a DisposableContainer.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun <T : Any> Maybe<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .apply { composite.add(this) }

/**
 * Switches this stream to subscribe on UI thread.
 */
fun <T : Any> Maybe<T>.subscribeOnUi(): Maybe<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Maybe<T>.subscribeOnIo(): Maybe<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Maybe<T>.subscribeOnComputation(): Maybe<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Maybe<T>.observeOnUi(): Maybe<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Maybe<T>.observeOnIo(): Maybe<T> =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Maybe<T>.observeOnComputation(): Maybe<T> =
  this.observeOn(Schedulers.computation())
