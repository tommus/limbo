package dev.windly.limbo.disposable

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's destroy event.
 */
fun LifecycleOwner.lifecycleDestroyCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = lifecycle,
      disposeOn = Lifecycle.Event.ON_DESTROY
    )
  }

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's pause event.
 */
fun LifecycleOwner.lifecyclePauseCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = lifecycle,
      disposeOn = Lifecycle.Event.ON_PAUSE
    )
  }

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's stop event.
 */
fun LifecycleOwner.lifecycleStopCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = lifecycle,
      disposeOn = Lifecycle.Event.ON_STOP
    )
  }
