@file:Suppress("NOTHING_TO_INLINE")

package co.windly.limbo.utility.view

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.res.ResourcesCompat
import android.view.View

//region Color

inline fun View.color(@ColorRes resId: Int): Int =
    ResourcesCompat.getColor(resources, resId, context.theme)

//endregion

//region Drawable

inline fun View.drawable(@DrawableRes resId: Int): Drawable? =
    ResourcesCompat.getDrawable(resources, resId, context.theme)

//endregion

//region String

inline fun View.string(@StringRes resId: Int): String =
    context.getString(resId)

inline fun View.string(@StringRes resId: Int, vararg formatArgs: Any): String =
    context.getString(resId, *formatArgs)

//endregion

//region Visibility

inline fun View.changeVisibility(flag: Boolean) {
  changeVisibility(flag, View.GONE)
}

inline fun View.changeVisibility(flag: Boolean, falseRes: Int) {
  val resource = if (flag) View.VISIBLE else falseRes
  visibility = resource
}

//endregion
