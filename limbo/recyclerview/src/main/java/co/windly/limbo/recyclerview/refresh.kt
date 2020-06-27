package co.windly.limbo.recyclerview

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import co.windly.limbo.utility.reactive.addSuccessTo
import com.jakewharton.rxbinding3.swiperefreshlayout.refreshes
import io.reactivex.disposables.CompositeDisposable

//region Refresh

@BindingAdapter(
  requireAll = true,
  value = ["disposables", "onRefresh"]
)
fun setOnRefresh(
  view: SwipeRefreshLayout, disposables: CompositeDisposable,
  onRefreshRequested: OnSwipeRefresh) {

  // Invoke a callable whenever swipe refresh is requested.
  view.refreshes().addSuccessTo(disposables) { onRefreshRequested.refresh() }
}

interface OnSwipeRefresh {

  /**
   * Calls in reaction to refresh.
   */
  fun refresh()
}

//endregion
