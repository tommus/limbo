package co.windly.limbo.utility.content

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat

//region Color

/**
 * Loads a color from given color resource.
 */
@ColorInt
fun Context.color(@ColorRes colorRes: Int): Int =
  ContextCompat.getColor(this, colorRes)

//endregion

//region Drawable

/**
 * Loads a drawable from given drawable resource.
 * Throws IllegalArgumentException if resource could not be loaded.
 */
fun Context.drawable(@DrawableRes drawableRes: Int): Drawable =
  ContextCompat.getDrawable(this, drawableRes)
    ?: throw IllegalArgumentException("Cannot load drawable from given resource.")

/**
 * Loads a drawable from given drawable resource.
 * Returns null in case if resource could not be loaded.
 */
fun Context.drawableOrNull(@DrawableRes drawableRes: Int): Drawable? =
  ContextCompat.getDrawable(this, drawableRes)

//endregion
