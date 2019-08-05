@file:Suppress("NOTHING_TO_INLINE")

package co.windly.limbo.utility.view

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat

//region Color

/**
 * Shortcut extension method which allows to load color resource.
 */
inline fun View.color(@ColorRes resId: Int): Int =
  ResourcesCompat.getColor(resources, resId, context.theme)

//endregion

//region Drawable

/**
 * Shortcut extension method which allows to load drawable resource.
 */
inline fun View.drawable(@DrawableRes resId: Int): Drawable? =
  ResourcesCompat.getDrawable(resources, resId, context.theme)

//endregion

//region String

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

//endregion

//region Visibility

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

//endregion
