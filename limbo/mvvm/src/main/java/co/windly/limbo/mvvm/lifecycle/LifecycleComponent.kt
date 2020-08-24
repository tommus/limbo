package co.windly.limbo.mvvm.lifecycle

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.DataBindingComponent
import androidx.lifecycle.Lifecycle
import co.windly.limbo.disposable.LifecycleCompositeDisposable
import co.windly.limbo.mvvm.binding.ClickDataBinding
import co.windly.limbo.utility.reactive.addSuccessTo
import co.windly.limbo.utility.reactive.throttledClicks
import com.jakewharton.rxbinding3.view.longClicks

open class LifecycleComponent(lifecycle: Lifecycle) : DataBindingComponent,
  LifecycleCompositeDisposable(lifecycle, Lifecycle.Event.ON_DESTROY) {

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
}
