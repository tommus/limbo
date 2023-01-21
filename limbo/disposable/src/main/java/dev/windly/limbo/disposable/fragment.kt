package dev.windly.limbo.disposable

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on fragment's destroy event.
 */
fun Fragment.lifecycleDestroyCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_DESTROY
    )
  }

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on fragment's pause event.
 */
fun Fragment.lifecyclePauseCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_PAUSE
    )
  }

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on fragment's stop event.
 */
fun Fragment.lifecycleStopCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_STOP
    )
  }
