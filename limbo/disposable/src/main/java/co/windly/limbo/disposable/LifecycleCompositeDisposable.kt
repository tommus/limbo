package co.windly.limbo.disposable

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer

/**
 * A composite disposable that observes the lifecycle of a lifecycle owner and disposes
 * a reactive stream when a certain lifecycle event state is reached.
 */
class LifecycleCompositeDisposable(
  private val lifecycle: Lifecycle,
  private val disposeOn: Event,
  private val composite: CompositeDisposable = CompositeDisposable()
) : Disposable by composite, DisposableContainer by composite, LifecycleEventObserver {

  //region Initialization

  init {

    // Add a lifecycle observer for (at least) initialized lifecycle owner.
    if (lifecycle.currentState >= Lifecycle.State.INITIALIZED) {
      lifecycle.addObserver(this)
    }
  }

  //endregion

  //region Composite Disposable

  /**
   * Adds a disposable to this container or disposes it if the
   * container has been disposed.
   */
  override fun add(disposable: Disposable): Boolean =
    composite.add(disposable)

  /**
   * Atomically adds the given array of disposables to the container or
   * disposes them all if the container has been disposed.
   */
  fun addAll(vararg disposables: Disposable): Boolean =
    composite.addAll(*disposables)

  /**
   * Atomically clears the container, then disposes all the previously
   * contained disposables.
   */
  fun clear() =
    composite.clear()

  /**
   * Removes (but does not dispose) the given disposable if it is part of this
   * container.
   */
  override fun delete(disposable: Disposable): Boolean =
    composite.delete(disposable)

  /**
   * Disposes all the previously contained disposables.
   */
  override fun dispose() {

    // Remove observe.
    lifecycle.removeObserver(this)

    // Dispose composite container.
    composite.dispose()
  }

  /**
   * Provides an information whether this disposable container was
   * already disposed.
   */
  override fun isDisposed(): Boolean =
    composite.isDisposed

  /**
   * Removes and disposes the given disposable if it is part of this
   * container.
   */
  override fun remove(disposable: Disposable): Boolean =
    composite.remove(disposable)

  /**
   * Returns the number of currently held disposables.
   */
  val size: Int
    get() = composite.size()

  //endregion

  //region State

  /**
   * Called when a state transition event happens.
   *
   * It tracks whether an event that the lifecycle owner transitioned to
   * it the one that should trigger streams disposal.
   */
  override fun onStateChanged(source: LifecycleOwner, event: Event) {

    // Call dispose on dispose event.
    if (disposeOn == event) {
      dispose()
    }
  }

  //endregion
}
