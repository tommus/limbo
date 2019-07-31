@file:Suppress("unused")

package co.windly.limbo.utility.reactive

import android.view.View
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS

//region Completable

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

/**
 * Immediately subscribes completable and adds to a CompositeDisposable.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw an error.
 */
fun Completable.addImmediatelyTo(composite: CompositeDisposable): Disposable =
  this
    .subscribe()
    .addTo(composite)

/**
 * Immediately subscribes completable and adds to a CompositeDisposable.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun Completable.addSuccessTo(composite: CompositeDisposable, lambda: () -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .addTo(composite)

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

//endregion

//region Maybe

/**
 * Immediately subscribes maybe and adds to a CompositeDisposable.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw an error.
 */
fun <T : Any> Maybe<T>.addImmediatelyTo(composite: CompositeDisposable): Disposable =
  this
    .subscribe()
    .addTo(composite)

/**
 * Immediately subscribes maybe and adds to a CompositeDisposable.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun <T : Any> Maybe<T>.addSuccessTo(composite: CompositeDisposable, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .addTo(composite)

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

//endregion

//region Single

/**
 * Immediately subscribes single and adds to a CompositeDisposable.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw an error.
 */
fun <T : Any> Single<T>.addImmediatelyTo(composite: CompositeDisposable): Disposable =
  this
    .subscribe()
    .addTo(composite)

/**
 * Immediately subscribes single and adds to a CompositeDisposable.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun <T : Any> Single<T>.addSuccessTo(composite: CompositeDisposable, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .addTo(composite)

/**
 * Switches this stream to subscribe on UI thread.
 */
fun <T : Any> Single<T>.subscribeOnUi(): Single<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Single<T>.subscribeOnIo(): Single<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Single<T>.subscribeOnComputation(): Single<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Single<T>.observeOnUi(): Single<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Single<T>.observeOnIo(): Single<T> =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Single<T>.observeOnComputation(): Single<T> =
  this.observeOn(Schedulers.computation())

//endregion

//region Observable

/**
 * Immediately subscribes observable and adds to a CompositeDisposable.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw an error.
 */
fun <T : Any> Observable<T>.addImmediatelyTo(composite: CompositeDisposable): Disposable =
  this
    .subscribe()
    .addTo(composite)

/**
 * Immediately subscribes observable and adds to a CompositeDisposable.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun <T : Any> Observable<T>.addSuccessTo(composite: CompositeDisposable, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .addTo(composite)

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

//endregion

//region Flowable

/**
 * Immediately subscribes flowable and adds to a CompositeDisposable.
 * NOTE: In case of error (and missing doOnComplete() and doOnError() methods) it is gonna throw an error.
 */
fun <T : Any> Flowable<T>.addImmediatelyTo(composite: CompositeDisposable): Disposable =
  this
    .subscribe()
    .addTo(composite)

/**
 * Immediately subscribes flowable and adds to a CompositeDisposable.
 * NOTE: In case of any errors - they will be ommitted silently.
 */
fun <T : Any> Flowable<T>.addSuccessTo(composite: CompositeDisposable, lambda: (result: T) -> Unit): Disposable =
  this
    .subscribe(lambda, { /* Mute. */ })
    .addTo(composite)

/**
 * Switches this stream to subscribe on UI thread.
 */
fun <T : Any> Flowable<T>.subscribeOnUi(): Flowable<T> =
  this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Flowable<T>.subscribeOnIo(): Flowable<T> =
  this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Flowable<T>.subscribeOnComputation(): Flowable<T> =
  this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Flowable<T>.observeOnUi(): Flowable<T> =
  this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Flowable<T>.observeOnIo(): Flowable<T> =
  this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Flowable<T>.observeOnComputation(): Flowable<T> =
  this.observeOn(Schedulers.computation())

//endregion

//region Subject

/**
 * Throttles subject emissions using provided window duration and unit.
 */
fun <T : Any> Subject<T>.throttled(windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<T> =
  this
    .throttleFirst(windowDuration, unit)

//endregion

//region View

/**
 * Throttles clicks on given view using provided window duration and unit.
 */
fun View.throttledClicks(windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<Unit> =
  this
    .clicks()
    .throttleFirst(windowDuration, unit)

//endregion
