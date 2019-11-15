package co.windly.limbo.recyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State

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

//endregion
