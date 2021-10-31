@file:Suppress("NOTHING_TO_INLINE")

package co.windly.limbo.utility.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import co.windly.limbo.utility.primitives.ZERO

/**
 * Shortcut extension method which allows to load color resource.
 */
inline fun View.color(@ColorRes resId: Int): Int =
  ResourcesCompat.getColor(resources, resId, context.theme)

/**
 * Shortcut extension method which allows to load drawable resource.
 */
inline fun View.drawable(@DrawableRes resId: Int): Drawable? =
  ResourcesCompat.getDrawable(resources, resId, context.theme)

/**
 * Explicitly requests for the current input method's soft
 * input area should be shown to the user.
 */
fun View.showSoftInput() {

  // Retrieve an access to the input method manager.
  val manager =
    context.getSystemService(Context.INPUT_METHOD_SERVICE)
      as InputMethodManager

  // Show soft input.
  manager.showSoftInput(this, Int.ZERO)
}

/**
 * Shortcut extension method which allows to load string resource.
 */
inline fun View.string(@StringRes resId: Int): String =
  context.getString(resId)

/**
 * Shortcut extension method which allows to load string resource.
 */
inline fun View.string(@StringRes resId: Int, vararg formatArgs: Any): String =
  context.getString(resId, *formatArgs)

/**
 * Allows to define view's visibility based on boolean argument.
 * View will become visible for argument which resolves to true.
 * View will be set to gone for argument which resolves to false.
 */
inline fun View.changeVisibility(flag: Boolean) {
  changeVisibility(flag, View.GONE)
}

/**
 * Allows to define view's visibility based on boolean argument.
 * View will become visible for argument which resolves to true.
 * View will be set to declared value for argument which resolves to false.
 */
inline fun View.changeVisibility(flag: Boolean, falseRes: Int) {
  val resource = if (flag) View.VISIBLE else falseRes
  visibility = resource
}
