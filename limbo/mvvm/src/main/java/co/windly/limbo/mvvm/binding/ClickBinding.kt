package co.windly.limbo.mvvm.binding

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.BindingAdapter
import co.windly.limbo.utility.reactive.addSuccessTo
import co.windly.limbo.utility.reactive.throttledClicks
import com.jakewharton.rxbinding3.view.longClicks
import io.reactivex.disposables.CompositeDisposable

//region Throttling

@BindingAdapter(
  requireAll = false,
  value = ["disposables", "throttledClicks", "longClicks"]
)
fun setClicks(
  view: View, disposables: CompositeDisposable,
  throttledClicks: OnClickListener?, longClicks: OnClickListener?) {

  // Register throttled clicks.
  if (throttledClicks != null) {
    view
      .throttledClicks()
      .addSuccessTo(disposables) { throttledClicks.onClick(view) }
  }

  // Register long clicks.
  if (longClicks != null) {
    view
      .longClicks()
      .addSuccessTo(disposables) { longClicks.onClick(view) }
  }
}

//endregion
