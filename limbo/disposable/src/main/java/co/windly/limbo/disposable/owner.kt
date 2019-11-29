package co.windly.limbo.disposable

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

//region Destroy

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

//endregion

//region Pause

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

//endregion

//region Stop

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

//endregion
