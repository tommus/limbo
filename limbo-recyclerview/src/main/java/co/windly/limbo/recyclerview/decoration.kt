package co.windly.limbo.recyclerview

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.InsetDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State
import co.windly.limbo.utility.content.drawable
import co.windly.limbo.utility.primitives.ZERO

/**
 * Allows to add item divider decoration with configurable
 * drawable resource and insets.
 */
fun RecyclerView.addDividerDecorationWithInsets(
  @DrawableRes dividerRes: Int,
  @DimenRes leftInsetRes: Int,
  @DimenRes topInsetRes: Int,
  @DimenRes rightInsetRes: Int,
  @DimenRes bottomInsetRes: Int
) {

  // Create an instance of divider decoration.
  val decoration =
    DividerItemDecoration(context, LinearLayout.VERTICAL)

  // Load divider drawable.
  val divider = context.drawable(dividerRes)

  // Load left inset.
  val insetLeft = when (leftInsetRes == Int.ZERO) {
    true -> Int.ZERO
    false -> resources.getDimensionPixelSize(leftInsetRes)
  }

  // Load top inset.
  val insetTop = when (topInsetRes == Int.ZERO) {
    true -> Int.ZERO
    false -> resources.getDimensionPixelSize(topInsetRes)
  }

  // Load right inset.
  val insetRight = when (rightInsetRes == Int.ZERO) {
    true -> Int.ZERO
    false -> resources.getDimensionPixelSize(rightInsetRes)
  }

  val insetBottom = when (bottomInsetRes == Int.ZERO) {
    true -> Int.ZERO
    false -> resources.getDimensionPixelSize(bottomInsetRes)
  }

  // Configure divider drawable insets.
  val insetDivider = InsetDrawable(
    divider, insetLeft, insetTop, insetRight, insetBottom)

  // Configure divider drawable.
  decoration.setDrawable(insetDivider)

  // Add prepared item decoration to recycler view.
  addItemDecoration(decoration)
}

/**
 * Allows to add item divider decoration with configurable
 * drawable resource and insets.
 *
 * NOTE: It cares about horizontal insets only. Vertical insets
 * will be left intact (equal to zero by default).
 */
fun RecyclerView.addDividerDecorationWithHorizontalInsets(
  @DrawableRes dividerRes: Int,
  @DimenRes leftInsetRes: Int,
  @DimenRes rightInsetRes: Int
) = addDividerDecorationWithInsets(
  dividerRes, leftInsetRes, 0, rightInsetRes, 0)

/**
 * Allows to add item divider decoration with configurable
 * drawable resource and insets.
 *
 * NOTE: It cares about vertical insets only. Horizontal insets
 * will be left intact (equal to zero by default).
 */
fun RecyclerView.addDividerDecorationWithVerticalInsets(
  @DrawableRes dividerRes: Int,
  @DimenRes topInsetRes: Int,
  @DimenRes bottomInsetRes: Int
) = addDividerDecorationWithInsets(
  dividerRes, 0, topInsetRes, 0, bottomInsetRes)

/**
 * Allows to define even spacing to all sides of the item by
 * providing single value or dimension resource.
 */
class EvenSpaceDecoration(spacing: Int) : SpaceDecoration(spacing, spacing, spacing, spacing) {

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))
}

/**
 * Allows to define even spacing to all sides of the item by
 * providing single value or dimension resource.
 */
fun RecyclerView.addEvenSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(EvenSpaceDecoration(context, spacingResId))

/**
 * Allows to define horizontal spacing to the item by providing single
 * value or dimension resource.
 */
class HorizontalSpaceDecoration(spacing: Int) : SpaceDecoration(spacing, 0, spacing, 0) {

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))
}

/**
 * Allows to define horizontal spacing to the item by providing single
 * value or dimension resource.
 */
fun RecyclerView.addHorizontalSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(HorizontalSpaceDecoration(context, spacingResId))

/**
 * Allows to define spacing to all sides of the item by
 * providing different values or dimension resources.
 */
open class SpaceDecoration(
  private val left: Int,
  private val top: Int,
  private val right: Int,
  private val bottom: Int
) : ItemDecoration() {

  constructor(
    context: Context,
    @DimenRes leftResId: Int,
    @DimenRes topResId: Int,
    @DimenRes rightResId: Int,
    @DimenRes bottomResId: Int
  ) :
    this(
      context.resources.getDimensionPixelSize(leftResId),
      context.resources.getDimensionPixelSize(topResId),
      context.resources.getDimensionPixelSize(rightResId),
      context.resources.getDimensionPixelSize(bottomResId)
    )

  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
    super.getItemOffsets(outRect, view, parent, state)

    // Update offsets based on provided spacing.
    outRect.set(left, top, right, bottom)
  }
}

/**
 * Allows to define spacing to all sides of the item by
 * providing different values or dimension resources.
 */
fun RecyclerView.addSpaceDecoration(
  @DimenRes leftResId: Int,
  @DimenRes topResId: Int,
  @DimenRes rightResId: Int,
  @DimenRes bottomResId: Int
) = addItemDecoration(
  SpaceDecoration(
    context, leftResId, topResId, rightResId, bottomResId))

/**
 * Allows to define vertical spacing to the item by providing single
 * value or dimension resource.
 */
class VerticalSpaceDecoration(spacing: Int) : SpaceDecoration(0, spacing, 0, spacing) {

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))
}

/**
 * Allows to define vertical spacing to the item by providing single
 * value or dimension resource.
 */
fun RecyclerView.addVerticalSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(VerticalSpaceDecoration(context, spacingResId))
