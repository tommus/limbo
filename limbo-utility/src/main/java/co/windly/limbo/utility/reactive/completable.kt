package co.windly.limbo.utility.reactive

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.internal.functions.Functions.EMPTY_ACTION
import io.reactivex.rxjava3.internal.functions.Functions.emptyConsumer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Immediately subscribes [Completable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: Cares only about errors. All successful emissions will be handled
 * silently.
 */
fun Completable.addErrorTo(
  composite: CompositeDisposable,
  lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe(EMPTY_ACTION, lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Completable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be rethrown as is.
 */
fun Completable.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe(
      EMPTY_ACTION,
      { /* Rethrow exception for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Completable] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be consumed silently.
 */
fun Completable.addSuccessTo(
  composite: DisposableContainer, lambda: () -> Unit): Disposable =
  this
    .subscribe(lambda, emptyConsumer())
    .apply { composite.add(this) }

/**
 * Modifies [Completable] to subscribe downstream subscriber on
 * [AndroidSchedulers.mainThread].
 */
fun Completable.subscribeOnUi(): Completable =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Completable] to subscribe downstream subscriber on
 * [Schedulers.io] thread.
 */
fun Completable.subscribeOnIo(): Completable =
  this.subscribeOn(Schedulers.io())

/**
 * Modifies [Completable] to subscribe downstream subscriber on
 * [Schedulers.computation] thread.
 */
fun Completable.subscribeOnComputation(): Completable =
  this.subscribeOn(Schedulers.computation())

/**
 * Modifies [Completable] to emit terminal events from the
 * [AndroidSchedulers.mainThread].
 */
fun Completable.observeOnUi(): Completable =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Completable] to emit terminal events from the [Schedulers.io]
 * thread.
 */
fun Completable.observeOnIo(): Completable =
  this.observeOn(Schedulers.io())

/**
 * Modifies [Completable] to emit terminal events from the
 * [Schedulers.computation] thread.
 */
fun Completable.observeOnComputation(): Completable =
  this.observeOn(Schedulers.computation())

/**
 * Modifies [Completable] so it emits <code>true</code> to the
 * subscriber [MutableLiveData] whenever the stream gets
 * subscribed and <code>false</code> whenever stream signals
 * <i>onError</i> and <i>onComplete</i>.
 */
fun Completable.notifyProgressUsing(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }

/**
 * Modifies [Completable] so it emits <code>true</code> to the
 * subscriber lambda method whenever the stream gets subscribed and
 * <code>false</code> whenever stream signals <i>onError</i> and
 * <i>onComplete</i>.
 */
fun Completable.onProgressChange(lambda: (inProgress: Boolean) -> Unit) =
  doOnSubscribe { lambda.invoke(true) }
    .doFinally { lambda.invoke(false) }
