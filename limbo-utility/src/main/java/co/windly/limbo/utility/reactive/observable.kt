package co.windly.limbo.utility.reactive

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.internal.functions.Functions.emptyConsumer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Immediately subscribes [Observable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: Cares only about errors. All successful emissions will be handled
 * silently.
 */
fun <T : Any> Observable<T>.addErrorTo(
  composite: CompositeDisposable, lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe(emptyConsumer(), lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Observable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be rethrown as is.
 */
fun <T : Any> Observable<T>.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe(
      emptyConsumer(),
      { /* Rethrow exception making for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Observable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be consumed silently.
 */
fun <T : Any> Observable<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, emptyConsumer())
    .apply { composite.add(this) }

/**
 * Modifies [Observable] to subscribe downstream subscriber on
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Observable<T>.subscribeOnUi(): Observable<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Observable] to subscribe downstream subscriber on
 * [Schedulers.io] thread.
 */
fun <T : Any> Observable<T>.subscribeOnIo(): Observable<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Modifies [Observable] to subscribe downstream subscriber on
 * [Schedulers.computation] thread.
 */
fun <T : Any> Observable<T>.subscribeOnComputation(): Observable<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Modifies [Observable] to emit terminal events from the
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Observable<T>.observeOnUi(): Observable<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Observable] to emit terminal events from the [Schedulers.io]
 * thread.
 */
fun <T : Any> Observable<T>.observeOnIo(): Observable<T> =
  this.observeOn(Schedulers.io())

/**
 * Modifies [Observable] to emit terminal events from the
 * [Schedulers.computation] thread.
 */
fun <T : Any> Observable<T>.observeOnComputation(): Observable<T> =
  this.observeOn(Schedulers.computation())
