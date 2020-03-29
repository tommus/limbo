package co.windly.limbo.mvvm.lifecycle

import android.util.Log
import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A lifecycle-aware observable that sends only new updates after subscription, used for events like
 * navigation and Snackbar messages.
 *
 * This avoids a common problem with events: on configuration change (like rotation) an update
 * can be emitted if the observer is active. This LiveData only calls the observable if there's an
 * explicit call to setValue() or call().
 *
 * Note that only one observer is going to be notified of changes.
 */
open class SingleLiveEvent<T> : MutableLiveData<T>() {

  //region Companion

  companion object {

    const val TAG = "SingleLiveEvent"
  }

  //endregion

  //region Pending Action

  private val pending: AtomicBoolean =
    AtomicBoolean(false)

  //endregion

  //region Observation

  @MainThread
  override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {

    // Log warning for multiple observers.
    if (hasActiveObservers()) {
      Log
        .v(TAG, "Multiple observers registered but only one will be notified of changes.")
    }

    // Observe the internal live data.
    super.observe(owner, by(observer))
  }

  private fun by(observer: Observer<in T>): Observer<T> = Observer {
    if (pending.compareAndSet(true, false)) {
      observer.onChanged(it)
    }
  }

  //endregion

  //region Value - Set

  override fun setValue(value: T) {

    // Mark action as pending.
    pending.set(true)

    // Change value.
    super.setValue(value)
  }

  fun call() {

    // Set nop value as result is not important.
    super.setValue(null)
  }

  //endregion

  //region Value - Post

  override fun postValue(value: T) {

    // Mark action as pending.
    pending.set(true)

    // Change value.
    super.postValue(value)
  }

  fun post() {

    // Post nop value as result is not important.
    super.postValue(null)
  }

  //endregion
}
