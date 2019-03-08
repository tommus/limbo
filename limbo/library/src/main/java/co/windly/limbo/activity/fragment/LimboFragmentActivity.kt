package co.windly.limbo.activity.fragment

import android.os.Bundle
import android.view.MotionEvent
import androidx.annotation.IdRes
import co.windly.limbo.R
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbo.fragment.base.LimboFragmentView
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode
import me.yokeyword.fragmentation.SupportActivityDelegate
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.anim.FragmentAnimator

abstract class LimboFragmentActivity<V : LimboFragmentActivityView, P : LimboFragmentActivityPresenter<V>> : LimboActivity<V, P>(), LimboFragmentActivityView {

  //region Ui

  protected val fragmentContainerId: Int
    @IdRes
    get() = R.id.fragmentContainer

  //endregion

  //region Support Activity

  protected val activityDelegate: SupportActivityDelegate
    by lazy { SupportActivityDelegate(this) }

  override val topFragment: LimboFragmentView
    get() = SupportHelper.getTopFragment(supportFragmentManager)

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    activityDelegate.onCreate(savedInstanceState)
  }

  override fun onPostCreate(savedInstanceState: Bundle?) {
    super.onPostCreate(savedInstanceState)
    activityDelegate.onPostCreate(savedInstanceState)
  }

  override fun onDestroy() {
    activityDelegate.onDestroy()
    super.onDestroy()
  }

  //endregion

  //region Touch Event

  override fun dispatchTouchEvent(ev: MotionEvent): Boolean =
    activityDelegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev)

  //endregion

  //region Back

  override fun onBackPressed() {
    activityDelegate.onBackPressed()
  }

  override fun onBackPressedSupport() {
    activityDelegate.onBackPressedSupport()
  }

  //endregion

  //region Fragment Animator

  override fun getFragmentAnimator(): FragmentAnimator =
    activityDelegate.fragmentAnimator

  override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator) {
    activityDelegate.fragmentAnimator = fragmentAnimator
  }

  override fun onCreateFragmentAnimator(): FragmentAnimator =
    activityDelegate.onCreateFragmentAnimator()

  override fun getSupportDelegate(): SupportActivityDelegate =
    activityDelegate

  override fun extraTransaction(): ExtraTransaction =
    activityDelegate.extraTransaction()

  override fun post(runnable: Runnable) {
    activityDelegate.post(runnable)
  }

  //endregion

  //region Fragment

  override fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView) {
    activityDelegate.loadRootFragment(containerId, toFragment)
  }

  override fun start(toFragment: LimboFragmentView) {
    activityDelegate.start(toFragment)
  }

  override fun start(toFragment: LimboFragmentView, @LaunchMode launchMode: Int) {
    activityDelegate.start(toFragment, launchMode)
  }

  override fun startWithPopTo(toFragment: LimboFragmentView, targetFragmentClass: Class<*>,
    includeTargetFragment: Boolean) {
    activityDelegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
  }

  override fun pop() {
    activityDelegate.pop()
  }

  override fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
    activityDelegate.popTo(targetFragmentClass, includeTargetFragment)
  }

  override fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean,
    afterPopTransactionRunnable: Runnable) {
    activityDelegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable)
  }

  override fun popTo(
    targetFragmentClass: Class<*>, includeTargetFragment: Boolean, afterPopTransactionRunnable: Runnable,
    popAnim: Int) {
    activityDelegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable, popAnim)
  }

  override fun <F : LimboFragmentView> findFragment(fragmentClass: Class<F>): F? =
    SupportHelper.findFragment(supportFragmentManager, fragmentClass)

  //endregion
}
