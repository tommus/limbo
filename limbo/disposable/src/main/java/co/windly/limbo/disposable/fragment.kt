package co.windly.limbo.disposable

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle

//region Destroy

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's destroy event.
 */
fun Fragment.lifecycleDestroyCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_DESTROY
    )
  }

//endregion

//region Pause

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's pause event.
 */
fun Fragment.lifecyclePauseCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_PAUSE
    )
  }

//endregion

//region Stop

/**
 * Lazily creates a lifecycle composite disposable that calls dispose method
 * on lifecycle owner's stop event.
 */
fun Fragment.lifecycleStopCompositeDisposable(): Lazy<LifecycleCompositeDisposable> =
  lazy {
    LifecycleCompositeDisposable(
      lifecycle = viewLifecycleOwner.lifecycle,
      disposeOn = Lifecycle.Event.ON_STOP
    )
  }

//endregion
