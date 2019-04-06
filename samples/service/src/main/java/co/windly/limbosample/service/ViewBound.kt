package co.windly.limbosample.service

import android.annotation.SuppressLint
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import co.windly.limbo.service.LimboServiceView
import co.windly.limbosample.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@ViewBoundScope
class ViewBound @Inject constructor(
  private val layoutInflater: LayoutInflater,
  private val windowManager: WindowManager
) : LimboServiceView<ViewBoundServiceView, ViewBoundService>(), ViewBoundServiceView {

  //region Presenter

  @Inject
  lateinit var viewBoundPresenter: ViewBoundService

  override fun createPresenter(): ViewBoundService =
    viewBoundPresenter

  //endregion

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    // Initialize view.
    initializeView()

    // Initialize click listener.
    initializeFloatingActionListener()
  }

  override fun onDestroy() {
    super.onDestroy()

    // Destroy view.
    destroyView()
  }

  //endregion

  //region Layout

  private lateinit var rootView: ConstraintLayout

  private lateinit var floatingButtonView: FloatingActionButton

  private lateinit var cardView: MaterialCardView

  @SuppressLint("InflateParams")
  override fun initializeView() {

    // Inflate entire view.
    rootView = layoutInflater
      .inflate(R.layout.service_bound, null) as ConstraintLayout

    // Retrieve a reference to children views.
    floatingButtonView = rootView.findViewById(R.id.floatingButtonView)
    cardView = rootView.findViewById(R.id.cardView)

    // Prepare window params.
    val params = provideRootLayoutParams(
      WindowManager.LayoutParams.WRAP_CONTENT,
      WindowManager.LayoutParams.WRAP_CONTENT
    ).also { it.gravity = Gravity.BOTTOM or Gravity.START }

    // Attach view to window.
    windowManager.addView(rootView, params)
  }

  private fun provideRootLayoutParams(width: Int, height: Int): WindowManager.LayoutParams =
    WindowManager.LayoutParams(
      width,
      height,
      provideTypeFlag(),
      provideLayoutFlag(),
      PixelFormat.TRANSLUCENT
    )

  @SuppressLint("InlinedApi")
  private fun provideTypeFlag(): Int = when (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    true -> WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
    false -> WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
  }

  private fun provideLayoutFlag(): Int =
    (WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
      or WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
      or WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
      or WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)

  override fun destroyView() {

    // Detach view from window.
    windowManager.removeView(rootView)
  }

  private fun refreshRootSize(width: Int, height: Int) {

    // Prepare window params.
    val params =
      provideRootLayoutParams(width, height)

    // Update root view.
    windowManager.updateViewLayout(rootView, params)
  }

  //endregion

  //region Floating Action

  override fun initializeFloatingActionListener() {

    // Attach click listener to floating action button.
    floatingButtonView
      .setOnClickListener { getPresenter().onFloatingActionButtonClicked() }
  }

  override fun snapToTop() {

    // Prepare params.
    val params = (rootView.layoutParams as WindowManager.LayoutParams)
      .also { it.width = WindowManager.LayoutParams.MATCH_PARENT }
      .also { it.height = WindowManager.LayoutParams.WRAP_CONTENT }
      .also { it.gravity = Gravity.TOP or Gravity.START }

    // Update root view.
    windowManager.updateViewLayout(rootView, params)
  }

  override fun snapToBottom() {

    // Prepare params.
    val params = (rootView.layoutParams as WindowManager.LayoutParams)
      .also { it.width = WindowManager.LayoutParams.WRAP_CONTENT }
      .also { it.height = WindowManager.LayoutParams.WRAP_CONTENT }
      .also { it.gravity = Gravity.BOTTOM or Gravity.START }

    // Update root view.
    windowManager.updateViewLayout(rootView, params)
  }

  //endregion

  //region Card

  private val isCardVisible: AtomicBoolean =
    AtomicBoolean(false)

  override fun toggleCard() {

    // Toggle card visibility.
    isCardVisible.set(!isCardVisible.get())

    // Reveal / conceal card.
    when (isCardVisible.get()) {
      true -> revealCard()
      false -> concealCard()
    }
  }

  private fun revealCard() {

    // Change card view visibility.
    cardView.visibility = View.VISIBLE

    // Snap to top.
    snapToTop()
  }

  private fun concealCard() {

    // Change card view visibility.
    cardView.visibility = View.GONE

    // Snap to bottom.
    snapToBottom()
  }

  //endregion
}
