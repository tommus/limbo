@file:Suppress("unused")

package dev.windly.limbo.utility.reactive

import android.view.View
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.Subject
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.MILLISECONDS

/**
 * Throttles subject emissions using provided window duration and unit.
 */
fun <T : Any> Subject<T>.throttled(
  windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<T> =
  this
    .throttleFirst(windowDuration, unit)

/**
 * Throttles clicks on given view using provided window duration and unit.
 */
fun View.throttledClicks(
  windowDuration: Long = 500L, unit: TimeUnit = MILLISECONDS): Observable<Unit> =
  this
    .clicks()
    .throttleFirst(windowDuration, unit)
