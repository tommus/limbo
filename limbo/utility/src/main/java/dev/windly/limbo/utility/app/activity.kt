package dev.windly.limbo.utility.app

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

/**
 * Requests to hide the soft input window from the context
 * of the window that is currently accepting input.
 */
fun Activity.hideSoftInput() {

  // Attempt to retrieve top-level decor view's context.
  val context = window.decorView.context

  // Retrieve an access to the input method manager.
  val manager =
    context.getSystemService(Context.INPUT_METHOD_SERVICE)
      as InputMethodManager

  // Hide soft input.
  manager.hideSoftInputFromWindow(
    window.decorView.windowToken, 0)
}
