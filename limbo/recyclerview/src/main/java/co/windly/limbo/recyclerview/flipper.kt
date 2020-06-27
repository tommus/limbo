package co.windly.limbo.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.widget.ViewFlipper

//region View Flipper

class ItemPreviewFlipper : ViewFlipper {

  private val initialView: Int

  constructor(context: Context) : super(context) {
    initialView = 0
  }

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

    // Access style attributes.
    val styled =
      context.theme
        .obtainStyledAttributes(attrs, R.styleable.ItemPreviewFlipperAttrs, 0, 0)

    // Extract initial view.
    initialView = try {
      styled.getInteger(R.styleable.ItemPreviewFlipperAttrs_initialView, 0)
    } finally {
      styled.recycle()
    }
  }

  override fun onFinishInflate() {
    super.onFinishInflate()

    // Load item based on given sample data.
    displayedChild = initialView % childCount
  }
}

//endregion
