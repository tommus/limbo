package dev.windly.limbo.mvvm.binding

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.BindingAdapter

interface ClickDataBinding {

  /**
   * Allows to register a click listener to any view. By default, all
   * clicks will be throttled using 1000 milliseconds window.
   */
  @BindingAdapter(
    requireAll = false,
    value = ["onThrottledClick", "throttleWindow"]
  )
  fun setOnThrottledClick(
    view: View, onThrottledClick: OnClickListener, throttleWindow: Long
  )

  /**
   * Allows to register a long click listener to any view.
   */
  @BindingAdapter(value = ["onLongClick"])
  fun setOnLongClick(view: View, onLongClick: OnClickListener)
}
