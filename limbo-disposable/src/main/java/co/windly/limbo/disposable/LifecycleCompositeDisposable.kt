package co.windly.limbo.disposable

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer

/**
 * A composite disposable that observes the lifecycle of a lifecycle owner and disposes
 * a reactive streams when a certain lifecycle event state is reached.
 */
open class LifecycleCompositeDisposable(
  protected val lifecycle: Lifecycle,
  protected val disposeOn: Event,
  protected val disposables: CompositeDisposable = CompositeDisposable()
) : Disposable by disposables, DisposableContainer by disposables, LifecycleEventObserver {

  init {

    // Add a lifecycle observer for (at least) initialized lifecycle owner.
    if (lifecycle.currentState >= Lifecycle.State.INITIALIZED) {
      registerLifecycleObserver()
    }
  }

  /**
   * Adds this object as lifecycle observer.
   */
  private fun registerLifecycleObserver() {
    lifecycle.addObserver(this)
  }

  /**
   * Adds a disposable to this container or disposes it if the
   * container has been disposed.
   */
  override fun add(disposable: Disposable): Boolean =
    disposables.add(disposable)

  /**
   * Atomically adds the given array of disposables to the container or
   * disposes them all if the container has been disposed.
   */
  fun addAll(vararg disposables: Disposable): Boolean =
    this.disposables.addAll(*disposables)

  /**
   * Atomically clears the container, then disposes all the previously
   * contained disposables.
   */
  fun clear() =
    disposables.clear()

  /**
   * Removes (but does not dispose) the given disposable if it is part of this
   * container.
   */
  override fun delete(disposable: Disposable): Boolean =
    disposables.delete(disposable)

  /**
   * Disposes all the previously contained disposables.
   */
  override fun dispose() {

    // Remove observer.
    lifecycle.removeObserver(this)

    // Dispose composite container.
    disposables.dispose()
  }

  /**
   * Provides an information whether this disposable container was
   * already disposed.
   */
  override fun isDisposed(): Boolean =
    disposables.isDisposed

  /**
   * Removes and disposes the given disposable if it is part of this
   * container.
   */
  override fun remove(disposable: Disposable): Boolean =
    disposables.remove(disposable)

  /**
   * Returns the number of currently held disposables.
   */
  val size: Int
    get() = disposables.size()

  /**
   * Called when a state transition event happens.
   *
   * It tracks whether an event that the lifecycle owner is transitioned to
   * is the one that should trigger streams disposal.
   */
  override fun onStateChanged(source: LifecycleOwner, event: Event) {

    // Call dispose on dispose event.
    if (disposeOn == event) {
      dispose()
    }
  }
}
