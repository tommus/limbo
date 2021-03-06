@file:Suppress("unused")

package co.windly.limbo.utility.reactive

import android.view.View
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS

//region Subject

/**
 * Throttles subject emissions using provided window duration and unit.
 */
fun <T : Any> Subject<T>.throttled(
  windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<T> =
  this
    .throttleFirst(windowDuration, unit)

//endregion

//region View

/**
 * Throttles clicks on given view using provided window duration and unit.
 */
fun View.throttledClicks(
  windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<Unit> =
  this
    .clicks()
    .throttleFirst(windowDuration, unit)

//endregion
