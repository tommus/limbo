package co.windly.limbo.utility.reactive

import androidx.lifecycle.MutableLiveData
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.schedulers.Schedulers

/**
 * Immediately subscribes observable and adds to a DisposableContainer.
 * NOTE: Cares only about errors. All successful emissions will be ignored.
 */
fun <T : Any> Maybe<T>.addErrorTo(
  composite: CompositeDisposable, lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe({ /* No-op. */ }, lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes maybe and adds to a DisposableContainer.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna
 * throw an error.
 */
fun <T : Any> Maybe<T>.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe(
      { /* No-op. */ },
      { /* Rethrow exception making for better stacktrace. */ throw it }
    )
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

/**
 * Emits to the given live data values true/false respectively on
 * subscribe/finally events.
 */
fun <T: Any> Maybe<T>.notifyProgressUsing(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }

/**
 * Emits to the given live data values true/false respectively on
 * subscribe/finally events.
 */
fun <T: Any> Maybe<T>.onProgressChange(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }
