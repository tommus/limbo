package co.windly.limbo.utility.reactive

import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer
import io.reactivex.rxjava3.internal.functions.Functions.emptyConsumer
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Immediately subscribes [Single] and adds to the [DisposableContainer].
 * <p>
 * NOTE: Cares only about errors. All successful emissions will be handled
 * silently.
 */
fun <T : Any> Single<T>.addErrorTo(
  composite: DisposableContainer, lambda: (throwable: Throwable) -> Unit): Disposable =
  this
    .subscribe(emptyConsumer(), lambda)
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Single] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be rethrown as is.
 */
fun <T : Any> Single<T>.addImmediatelyTo(composite: DisposableContainer): Disposable =
  this
    .subscribe(
      emptyConsumer(),
      { /* Rethrow exception making for better stacktrace. */ throw it }
    )
    .apply { composite.add(this) }

/**
 * Immediately subscribes [Single] and adds to the [DisposableContainer].
 * <p>
 * NOTE: All the errors will be consumed silently.
 */
fun <T : Any> Single<T>.addSuccessTo(
  composite: DisposableContainer, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, emptyConsumer())
    .apply { composite.add(this) }

/**
 * Modifies [Single] to subscribe downstream subscriber on
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Single<T>.subscribeOnUi(): Single<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Single] to subscribe downstream subscriber on
 * [Schedulers.io] thread.
 */
fun <T : Any> Single<T>.subscribeOnIo(): Single<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Modifies [Single] to subscribe downstream subscriber on
 * [Schedulers.computation] thread.
 */
fun <T : Any> Single<T>.subscribeOnComputation(): Single<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Modifies [Single] to emit terminal events from the
 * [AndroidSchedulers.mainThread].
 */
fun <T : Any> Single<T>.observeOnUi(): Single<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Modifies [Single] to emit terminal events from the [Schedulers.io]
 * thread.
 */
fun <T : Any> Single<T>.observeOnIo(): Single<T> =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Single<T>.observeOnComputation(): Single<T> =
  this.observeOn(Schedulers.computation())

/**
 * Modifies [Single] so it emits <code>true</code> to the
 * subscriber [MutableLiveData] whenever the stream gets
 * subscribed and <code>false</code> whenever stream signals
 * <i>onError</i> and <i>onSuccess</i>.
 */
fun <T : Any> Single<T>.notifyProgressUsing(emitter: MutableLiveData<Boolean>) =
  doOnSubscribe { emitter.postValue(true) }
    .doFinally { emitter.postValue(false) }

/**
 * Modifies [Single] so it emits <code>true</code> to the
 * subscriber lambda method whenever the stream gets subscribed and
 * <code>false</code> whenever stream signals <i>onError</i> and
 * <i>onSuccess</i>.
 */
fun <T : Any> Single<T>.onProgressChange(lambda: (inProgress: Boolean) -> Unit) =
  doOnSubscribe { lambda.invoke(true) }
    .doFinally { lambda.invoke(false) }
