package dev.windly.limbo.utility.reactive

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.internal.functions.Functions.emptyConsumer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Immediately subscribes [Maybe] and adds to the [DisposableContainer].
 * <p>
 * NOTE: Cares only about errors. All successful emissions will be handled
 * silently.
 */
fun <T : Any> Maybe<T>.addErrorTo(
  composite: CompositeDisposable,
  lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe(emptyConsumer(), lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Maybe] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be rethrown as is.
 */
fun <T : Any> Maybe<T>.addImmediatelyTo(
  composite: DisposableContainer): Disposable =
  this
    .subscribe(
      emptyConsumer(),
      { /* Rethrow exception for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Maybe] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be consumed silently.
 */
fun <T : Any> Maybe<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .apply { composite.add(this) }

/**
 * Modifies [Maybe] to subscribe downstream subscriber on
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Maybe<T>.subscribeOnUi(): Maybe<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Maybe] to subscribe downstream subscriber on
 * [Schedulers.io] thread.
 */
fun <T : Any> Maybe<T>.subscribeOnIo(): Maybe<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Modifies [Maybe] to subscribe downstream subscriber on
 * [Schedulers.computation] thread.
 */
fun <T : Any> Maybe<T>.subscribeOnComputation(): Maybe<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Modifies [Maybe] to emit terminal events from the
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Maybe<T>.observeOnUi(): Maybe<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Maybe] to emit terminal events from the [Schedulers.io]
 * thread.
 */
fun <T : Any> Maybe<T>.observeOnIo(): Maybe<T> =
  this.observeOn(Schedulers.io())

/**
 * Modifies [Maybe] to emit terminal events from the
 * [Schedulers.computation] thread.
 */
fun <T : Any> Maybe<T>.observeOnComputation(): Maybe<T> =
  this.observeOn(Schedulers.computation())

/**
 * Modifies [Maybe] so it emits <code>true</code> to the
 * subscriber [MutableLiveData] whenever the stream gets
 * subscribed and <code>false</code> whenever stream signals
 * <i>onError</i>, <i>onSuccess</i> and <i>onComplete</i>.
 */
fun <T : Any> Maybe<T>.notifyProgressUsing(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }

/**
 * Modifies [Maybe] so it emits <code>true</code> to the
 * subscriber lambda method whenever the stream gets subscribed and
 * <code>false</code> whenever stream signals <i>onError</i>, <i>onSuccess</i>
 * and <i>onComplete</i>.
 */
fun <T : Any> Maybe<T>.onProgressChange(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }
