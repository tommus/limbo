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
fun Completable.subscribeOnUi() =
    this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun Completable.subscribeOnIo() =
    this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun Completable.subscribeOnComputation() =
    this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun Completable.observeOnUi() =
    this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun Completable.observeOnIo() =
    this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun Completable.observeOnComputation() =
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
fun <T : Any> Maybe<T>.subscribeOnUi() =
    this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Maybe<T>.subscribeOnIo() =
    this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Maybe<T>.subscribeOnComputation() =
    this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Maybe<T>.observeOnUi() =
    this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Maybe<T>.observeOnIo() =
    this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Maybe<T>.observeOnComputation() =
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
fun <T : Any> Single<T>.subscribeOnUi() =
    this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Single<T>.subscribeOnIo() =
    this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Single<T>.subscribeOnComputation() =
    this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Single<T>.observeOnUi() =
    this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Single<T>.observeOnIo() =
    this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Single<T>.observeOnComputation() =
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
fun <T : Any> Observable<T>.subscribeOnUi() =
    this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Observable<T>.subscribeOnIo() =
    this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Observable<T>.subscribeOnComputation() =
    this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Observable<T>.observeOnUi() =
    this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Observable<T>.observeOnIo() =
    this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Observable<T>.observeOnComputation() =
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
fun <T : Any> Flowable<T>.subscribeOnUi() =
    this.subscribeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to subscribe on IO thread.
 */
fun <T : Any> Flowable<T>.subscribeOnIo() =
    this.subscribeOn(Schedulers.io())

/**
 * Switches this stream to subscribe on computation thread.
 */
fun <T : Any> Flowable<T>.subscribeOnComputation() =
    this.subscribeOn(Schedulers.computation())

/**
 * Switches this stream to observe on UI thread.
 */
fun <T : Any> Flowable<T>.observeOnUi() =
    this.observeOn(AndroidSchedulers.mainThread())

/**
 * Switches this stream to observe on IO thread.
 */
fun <T : Any> Flowable<T>.observeOnIo() =
    this.observeOn(Schedulers.io())

/**
 * Switches this stream to observe on computation thread.
 */
fun <T : Any> Flowable<T>.observeOnComputation() =
    this.observeOn(Schedulers.computation())

//endregion

//region View

/**
 * Throttles clicks on given view with provided window duration.
 */
fun View.throttledClicks(windowDuration: Long = 500): Observable<Unit> =
    this
        .clicks()
        .throttleFirst(windowDuration, MILLISECONDS)

//endregion
