package co.windly.limbo.mvvm.lifecycle

import androidx.annotation.MainThread
import androidx.collection.ArraySet
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/**
 * A lifecycle-aware observable that sends only new updates after subscription,
 * used for events like navigation and messages.
 *
 * This avoids a common problem with events: on configuration change (like
 * rotation) an update can be emitted if the observer is active. This LiveData
 * only calls the observable if there's an explicit call to setValue() or
 * call().
 *
 * Note that unlikely to SingleLiveEvent<T> multiple observers can be notified
 * of changes.
 */
open class LiveEvent<T> : MediatorLiveData<T>() {

  //region Observers

  private val observers = ArraySet<PendingObserverWrapper<in T>>()

  //endregion

  //region Observation

  @MainThread
  override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

    // Wrap the original observer.
    val wrapper = PendingObserverWrapper(observer)

    // Add wrapper as observer.
    observers.add(wrapper)

    // Observe the internal live data.
    super.observe(owner, wrapper)
  }

  @MainThread
  override fun observeForever(observer: Observer<in T>) {

    // Wrap the original observer.
    val wrapper = PendingObserverWrapper(observer)

    // Add wrapper as observer.
    observers.add(wrapper)

    // Observe the internal live data.
    super.observeForever(wrapper)
  }

  @MainThread
  @Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
  override fun removeObserver(observer: Observer<in T>) {

    // Remove the observer. If previously added to observers.
    if (observers.remove<Observer<in T>>(observer)) {
      super.removeObserver(observer)
      return
    }

    // If observer wasn't found by remove() method - try to find-and-remove it
    // using iteration over the observers collection.
    val iterator = observers.iterator()
    while (iterator.hasNext()) {
      val wrapper = iterator.next()

      // Remove found observer.
      if (wrapper.observer == observer) {
        iterator.remove()
        super.removeObserver(wrapper)
        break
      }
    }
  }

  //endregion

  //region Value - Set

  @MainThread
  override fun setValue(value: T?) {

    // Notify observers about pending update.
    observers.forEach { it.newValue() }

    // Change value.
    super.setValue(value)
  }

  fun call() {

    // Set nop value as result is not important.
    value = null
  }

  //endregion

  //region Value - Post

  override fun postValue(value: T) {

    // Notify observers about pending update.
    observers.forEach { it.newValue() }

    // Change value.
    super.postValue(value)
  }

  fun post() {

    // Notify observers about pending update.
    observers.forEach { it.newValue() }

    // Post nop value as result is not important.
    super.postValue(null)
  }

  //endregion

  //region Wrapper

  /**
   * Wrapper that internally denotes pending actions.
   */
  private class PendingObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {

    /**
     * Keeps track whether any pending action awaits notification for
     * given observer.
     */
    private var pending = false

    /**
     * Called when the data is changed.
     */
    override fun onChanged(t: T?) {

      // Notify observer only for pending actions.
      if (pending) {

        // Update there is no pending action anymore.
        pending = false

        // Notify observer.
        observer.onChanged(t)
      }
    }

    /**
     * Raises an information that pending action awaits for the observer.
     */
    fun newValue() {
      pending = true
    }
  }

  //endregion
}

/**
 * Allows to convert regular live data to pending action aware live event.
 */
fun <T> LiveData<T>.asLiveEvent(): LiveData<T> {

  // Designates an instance of live event.
  val result = LiveEvent<T>()

  // Adds this stream as a source for live event.
  result.addSource(this) { result.value = it }

  // Returns freshly created live event.
  return result
}
