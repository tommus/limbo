package co.windly.limbo.utility.reactive

import androidx.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer
import io.reactivex.schedulers.Schedulers

/**
 * Immediately subscribes completable and adds to a DisposableContainer.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna
 * throw an error.
 */
fun Completable.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe()
    .apply { composite.add(this) }

/**
 * Immediately subscribes completable and adds to a DisposableContainer.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun Completable.addSuccessTo(composite: DisposableContainer, lambda: () -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .apply { composite.add(this) }

/**
 * Switches this stream to subscribe on UI thread.
 */
fun Completable.subscribeOnUi(): Completable =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun Completable.subscribeOnIo(): Completable =
  this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun Completable.subscribeOnComputation(): Completable =
  this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun Completable.observeOnUi(): Completable =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun Completable.observeOnIo(): Completable =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun Completable.observeOnComputation(): Completable =
  this.observeOn(Schedulers.computation())

/**
 * Emits to the given live data values true/false respectively on subscribe/finally events.
 */
fun Completable.notifyProgressUsing(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }

/**
 * Calls given lambda passing true/false respectively on subscribe/finally events.
 */
fun Completable.onProgressChange(lambda: (inProgress: Boolean) -> Unit) =
  doOnSubscribe { lambda.invoke(true) }
    .doFinally { lambda.invoke(false) }
