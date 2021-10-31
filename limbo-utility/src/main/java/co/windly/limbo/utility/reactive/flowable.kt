package co.windly.limbo.utility.reactive

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.internal.functions.Functions.emptyConsumer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Immediately subscribes [Flowable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: Cares only about errors. All successful emissions will be handled
 * silently.
 */
fun <T : Any> Flowable<T>.addErrorTo(
  composite: CompositeDisposable,
  lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe(emptyConsumer(), lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Flowable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be rethrown as is.
 */
fun <T : Any> Flowable<T>.addImmediatelyTo(
  composite: DisposableContainer): Disposable =
  this
    .subscribe(
      emptyConsumer(),
      { /* Rethrow exception for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Flowable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be consumed silently.
 */
fun <T : Any> Flowable<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, emptyConsumer())
    .apply { composite.add(this) }

/**
 * Modifies [Flowable] to subscribe downstream subscriber on
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Flowable<T>.subscribeOnUi(): Flowable<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Flowable] to subscribe downstream subscriber on
 * [Schedulers.io] thread.
 */
fun <T : Any> Flowable<T>.subscribeOnIo(): Flowable<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Modifies [Flowable] to subscribe downstream subscriber on
 * [Schedulers.computation] thread.
 */
fun <T : Any> Flowable<T>.subscribeOnComputation(): Flowable<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Modifies [Flowable] to emit terminal events from the
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Flowable<T>.observeOnUi(): Flowable<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Flowable] to emit terminal events from the [Schedulers.io]
 * thread.
 */
fun <T : Any> Flowable<T>.observeOnIo(): Flowable<T> =
  this.observeOn(Schedulers.io())

/**
 * Modifies [Flowable] to emit terminal events from the
 * [Schedulers.computation] thread.
 */
fun <T : Any> Flowable<T>.observeOnComputation(): Flowable<T> =
  this.observeOn(Schedulers.computation())
