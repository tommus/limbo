package co.windly.limbo.fragment.base

import android.os.Bundle
import android.view.View
import co.windly.limbo.LimboView
import co.windly.limbo.activity.fragment.LimboFragmentActivityView
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode

interface LimboFragmentView : LimboView, ISupportFragment {

  //region Soft Input

  fun hideSoftInput()

  fun showSoftInput(view: View)

  //endregion

  //region Fragment

  fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView)

  fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView, addToBackStack: Boolean,
    allowAnimation: Boolean)

  fun loadMultipleRootFragment(containerId: Int, showPosition: Int, vararg toFragments: LimboFragmentView)

  fun start(toFragment: LimboFragmentView)

  fun start(toFragment: LimboFragmentView, @LaunchMode launchMode: Int)

  fun startForResult(toFragment: LimboFragmentView, requestCode: Int)

  override fun setFragmentResult(resultCode: Int, bundle: Bundle)

  fun startWithPop(toFragment: LimboFragmentView)

  fun startWithPopTo(toFragment: LimboFragmentView, targetFragmentClass: Class<*>, includeTargetFragment: Boolean)

  fun replaceFragment(toFragment: LimboFragmentView, addToBackStack: Boolean)

  fun showHideFragment(showFragment: LimboFragmentView)

  fun showHideFragment(showFragment: LimboFragmentView, hideFragment: LimboFragmentView)

  fun pop()

  fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean)

  fun <T : LimboFragmentView> findChildFragment(fragmentClass: Class<T>): T?

  fun <T : LimboFragmentView> getParentFragment(fragmentClass: Class<T>): T

  //endregion

  //region Activity

  fun <T : LimboFragmentActivityView> getActivity(activityClass: Class<T>): T

  //endregion
}
