package dev.windly.limbo.recyclerview.binding

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

interface SwipeRefreshDataBinding {

  /**
   * Allows to register a swipe refresh listener.
   *
   * Example implementation in reactive manner can look like:
   *
   * override fun setOnRefresh(view: SwipeRefreshLayout, onRefreshRequested: OnSwipeRefresh) {
   *   view
   *     .refreshes()
   *     .addSuccessTo(disposables) { onRefreshRequested.refresh() }
   * }
   */
  @BindingAdapter(
    requireAll = true,
    value = ["onRefresh"]
  )
  fun setOnRefresh(view: SwipeRefreshLayout, onRefreshRequested: OnSwipeRefreshListener)

  /**
   * Interface definition for a callback to be invoked when a view is swipe
   * refreshed.
   */
  interface OnSwipeRefreshListener {

    /**
     * Called when a view has been swipe refreshed.
     */
    fun onSwipeRefresh()
  }
}
