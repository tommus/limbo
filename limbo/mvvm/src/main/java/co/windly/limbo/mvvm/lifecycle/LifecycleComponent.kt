package co.windly.limbo.mvvm.lifecycle

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import co.windly.limbo.mvvm.binding.ClickDataBinding
import co.windly.limbo.utility.reactive.addSuccessTo
import co.windly.limbo.utility.reactive.throttledClicks
import com.jakewharton.rxbinding3.view.longClicks
import io.reactivex.disposables.CompositeDisposable

class LifecycleComponent(private val lifecycle: Lifecycle) : DataBindingComponent,
  LifecycleObserver {

  //region Disposables

  private val disposables: CompositeDisposable =
    CompositeDisposable()

  //endregion

  //region Click

  override fun getClickDataBinding(): ClickDataBinding {

    return object : ClickDataBinding {

      override fun setOnThrottledClick(
        view: View, onThrottledClick: OnClickListener, throttleWindow: Long) {
        view
          .throttledClicks(throttleWindow)
          .addSuccessTo(disposables) { onThrottledClick.onClick(view) }
      }

      override fun setOnLongClick(view: View, onLongClick: OnClickListener) {
        view
          .longClicks()
          .addSuccessTo(disposables) { onLongClick.onClick(view) }
      }
    }
  }

  //endregion

  //region Dispose

  /**
   * Disposes all registered reactive streams. This method is being
   * called whenever lifecycle owner will emit on destroy event.
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  fun dispose() {

    // Clear disposables.
    disposables.clear()

    // Remove this object from lifecycle observation.
    lifecycle.removeObserver(this)
  }

  //endregion

  //region Initialization

  init {

    // Subscribe this object as lifecycle observer.
    lifecycle.addObserver(this)
  }

  //endregion
}
