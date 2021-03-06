package co.windly.limbo.utility.reactive

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.schedulers.Schedulers

/**
 * Immediately subscribes observable and adds to a DisposableContainer.
 * NOTE: Cares only about errors. All successful emissions will be ignored.
 */
fun <T : Any> Observable<T>.addErrorTo(
  composite: CompositeDisposable, lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe({ /* No-op. */ }, lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes observable and adds to a DisposableContainer.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw
 * an error.
 */
fun <T : Any> Observable<T>.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe(
      { /* No-op. */ },
      { /* Rethrow exception making for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes observable and adds to a DisposableContainer.
 * NOTE: In case of any errors - they will be omitted silently.
 */
fun <T : Any> Observable<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .apply { composite.add(this) }

/**
 * Switches this stream to subscribe on UI thread.
 */
fun <T : Any> Observable<T>.subscribeOnUi(): Observable<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Observable<T>.subscribeOnIo(): Observable<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Observable<T>.subscribeOnComputation(): Observable<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Observable<T>.observeOnUi(): Observable<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Observable<T>.observeOnIo(): Observable<T> =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Observable<T>.observeOnComputation(): Observable<T> =
  this.observeOn(Schedulers.computation())
