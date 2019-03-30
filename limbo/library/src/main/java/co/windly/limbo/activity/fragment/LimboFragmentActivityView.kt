package co.windly.limbo.activity.fragment

import co.windly.limbo.LimboView
import co.windly.limbo.fragment.base.LimboFragmentView
import me.yokeyword.fragmentation.ISupportActivity
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode

interface LimboFragmentActivityView : LimboView, ISupportActivity {

  //region Fragment

  val topFragment: LimboFragmentView

  fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView)

  fun start(toFragment: LimboFragmentView)

  fun start(toFragment: LimboFragmentView, @LaunchMode launchMode: Int)

  fun startWithPopTo(toFragment: LimboFragmentView, targetFragmentClass: Class<*>, includeTargetFragment: Boolean)

  fun pop()

  fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean)

  fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean, afterPopTransactionRunnable: Runnable)

  fun popTo(
    targetFragmentClass: Class<*>, includeTargetFragment: Boolean, afterPopTransactionRunnable: Runnable, popAnim: Int)

  fun <F : LimboFragmentView> findFragment(fragmentClass: Class<F>): F?

  //endregion
}
