package co.windly.limbo.disposable

import android.view.View
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer

/**
 * A composite disposable that observes the view state changes and disposes
 * a reactive streams when view is detached from window.
 */
class ViewCompositeDisposable(
  private val view: View,
  private val composite: CompositeDisposable = CompositeDisposable()
) : Disposable by composite, DisposableContainer by composite, View.OnAttachStateChangeListener {

  init {

    // Add a lifecycle observer for a view attached to the window.
    if (view.isAttachedToWindow || view.windowToken != null) {
      view.addOnAttachStateChangeListener(this)
    }
  }

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

    // Remove view state change listener.
    view.removeOnAttachStateChangeListener(this)

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

  /**
   * Called when the view is attached to a window.
   */
  override fun onViewAttachedToWindow(view: View?) =
    Unit

  /**
   * Called when the view is detached from a window.
   *
   * It disposes all the previously contained disposables.
   */
  override fun onViewDetachedFromWindow(view: View?) =
    dispose()
}
