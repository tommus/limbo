package co.windly.limbo.recyclerview

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.InsetDrawable
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State

//region Divider

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
  val divider =
    ContextCompat.getDrawable(context, dividerRes)
      ?: throw IllegalArgumentException(
        "Cannot load drawable resource for divider.")

  // Define divider insets.
  val insetLeft = resources.getDimensionPixelSize(leftInsetRes)
  val insetTop = resources.getDimensionPixelSize(topInsetRes)
  val insetRight = resources.getDimensionPixelSize(rightInsetRes)
  val insetBottom = resources.getDimensionPixelSize(bottomInsetRes)

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

//endregion

//region Even

/**
 * Allows to define even spacing to all sides of the item by
 * providing single value or dimension resource.
 */
class EvenSpaceDecoration(spacing: Int) : SpaceDecoration(spacing, spacing, spacing, spacing) {

  //region Constructor

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))

  //endregion
}

/**
 * Allows to define even spacing to all sides of the item by
 * providing single value or dimension resource.
 */
fun RecyclerView.addEventSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(EvenSpaceDecoration(context, spacingResId))

//endregion

//region Horizontal

/**
 * Allows to define horizontal spacing to the item by providing single
 * value or dimension resource.
 */
class HorizontalSpaceDecoration(spacing: Int) : SpaceDecoration(spacing, 0, spacing, 0) {

  //region Constructor

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))

  //endregion
}

/**
 * Allows to define horizontal spacing to the item by providing single
 * value or dimension resource.
 */
fun RecyclerView.addHorizontalSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(HorizontalSpaceDecoration(context, spacingResId))

//endregion

//region Space

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

  //region Constructor

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

  //endregion

  //region Offset

  override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
    super.getItemOffsets(outRect, view, parent, state)

    // Update offsets based on provided spacing.
    outRect.set(left, top, right, bottom)
  }

  //endregion
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
) = addItemDecoration(SpaceDecoration(
  context, leftResId, topResId, rightResId, bottomResId))

//endregion

//region Vertical

/**
 * Allows to define vertical spacing to the item by providing single
 * value or dimension resource.
 */
class VerticalSpaceDecoration(spacing: Int) : SpaceDecoration(0, spacing, 0, spacing) {

  //region Constructor

  constructor(context: Context, @DimenRes spacingResId: Int) :
    this(context.resources.getDimensionPixelSize(spacingResId))

  //endregion
}

/**
 * Allows to define vertical spacing to the item by providing single
 * value or dimension resource.
 */
fun RecyclerView.addVerticalSpaceDecoration(@DimenRes spacingResId: Int = R.dimen.size_p4) =
  addItemDecoration(VerticalSpaceDecoration(context, spacingResId))

//endregion
