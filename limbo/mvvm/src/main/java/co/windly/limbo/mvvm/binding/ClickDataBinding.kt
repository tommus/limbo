package co.windly.limbo.mvvm.binding

import android.view.View
import android.view.View.OnClickListener
import androidx.databinding.BindingAdapter
import co.windly.limbo.utility.primitives.ZERO
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class ClickDataBinding {

  /**
   * Allows to register a click listener to any view. By default, all
   * clicks will be throttled using 1000 milliseconds window.
   */
  @ExperimentalCoroutinesApi
  @BindingAdapter(
    requireAll = false,
    value = ["onThrottledClick", "throttleWindow"]
  )
  fun setOnThrottledClick(
    view: View, onThrottledClick: OnClickListener, throttleWindow: Long = 1_000L) {
    view
      .context
      .
    view
      .clicks()
      .throttleFirst(throttleWindow)
      .collect { onThrottledClick.onClick(view) }
  }

  @ExperimentalCoroutinesApi
  fun View.clicks(): Flow<Unit> = callbackFlow {
    val listener = OnClickListener { offer(Unit) }
    setOnClickListener(listener)
    awaitClose { setOnClickListener(null) }
  }

  fun <T> Flow<T>.throttleFirst(throttleWindow: Long = 1_000L): Flow<T> = flow {

    // Designate a space for a window occurrence comparison.
    var then = Long.ZERO

    collect { value ->

      // Timestamp current time.
      val now =
        System.currentTimeMillis()

      // Emit value if exceeded inertia window.
      if (now - then >= throttleWindow) {
        then = now
        emit(value)
      }
    }
  }

  /**
   * Allows to register a long click listener to any view.
   */
  @BindingAdapter(value = ["onLongClick"])
  fun setOnLongClick(view: View, onLongClick: OnClickListener) {
    // TODO:
  }
}
