package co.windly.limbo.fragment.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.annotation.LayoutRes
import co.windly.limbo.activity.fragment.LimboFragmentActivityView
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.anim.FragmentAnimator

abstract class LimboFragment<V : LimboFragmentView, P : LimboFragmentPresenter<V>> : MvpFragment<V, P>(), LimboFragmentView {

  //region Reactive

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Ui

  @get:LayoutRes
  protected abstract val layout: Int

  //endregion

  //region Support Fragment

  protected val fragmentDelegate: SupportFragmentDelegate
    by lazy { SupportFragmentDelegate(this) }

  //endregion

  //region Lifecycle

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    fragmentDelegate.onAttach(context as Activity)
  }

  override fun onAttach(activity: Activity?) {
    super.onAttach(activity)
    fragmentDelegate.onAttach(activity)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(layout, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    fragmentDelegate.onCreate(savedInstanceState)
  }

  override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? =
    fragmentDelegate.onCreateAnimation(transit, enter, nextAnim)

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    fragmentDelegate.onActivityCreated(savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    fragmentDelegate.onSaveInstanceState(outState)
  }

  override fun onResume() {
    super.onResume()
    fragmentDelegate.onResume()
  }

  override fun onPause() {
    super.onPause()
    fragmentDelegate.onPause()
  }

  override fun onDestroy() {
    super.onDestroy()
    fragmentDelegate.onDestroy()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    fragmentDelegate.onDestroyView()
  }

  override fun onDetach() {

    // Clear presenter-bound disposables.
    getPresenter().clearDisposables()

    // Clear view-bound disposables.
    clearDisposables()

    super.onDetach()
  }

  override fun onHiddenChanged(hidden: Boolean) {
    super.onHiddenChanged(hidden)
    fragmentDelegate.onHiddenChanged(hidden)
  }

  override fun setUserVisibleHint(isVisibleToUser: Boolean) {
    super.setUserVisibleHint(isVisibleToUser)
    fragmentDelegate.setUserVisibleHint(isVisibleToUser)
  }

  //endregion

  //region Back

  override fun onBackPressedSupport(): Boolean =
    fragmentDelegate.onBackPressedSupport()

  //endregion

  //region Fragment Animator

  override fun onCreateFragmentAnimator(): FragmentAnimator =
    fragmentDelegate.onCreateFragmentAnimator()

  override fun getFragmentAnimator(): FragmentAnimator =
    fragmentDelegate.fragmentAnimator

  override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator) {
    fragmentDelegate.fragmentAnimator = fragmentAnimator
  }

  override fun getSupportDelegate(): SupportFragmentDelegate =
    fragmentDelegate

  override fun extraTransaction(): ExtraTransaction =
    fragmentDelegate.extraTransaction()

  override fun enqueueAction(runnable: Runnable) {
    fragmentDelegate.enqueueAction(runnable)
  }

  override fun post(runnable: Runnable) {
    fragmentDelegate.post(runnable)
  }

  override fun onEnterAnimationEnd(savedInstanceState: Bundle?) {
    fragmentDelegate.onEnterAnimationEnd(savedInstanceState)
  }

  override fun onLazyInitView(savedInstanceState: Bundle?) {
    fragmentDelegate.onLazyInitView(savedInstanceState)
  }

  override fun onSupportVisible() {
    fragmentDelegate.onSupportVisible()
  }

  override fun onSupportInvisible() {
    fragmentDelegate.onSupportInvisible()
  }

  override fun isSupportVisible(): Boolean =
    fragmentDelegate.isSupportVisible

  override fun setFragmentResult(resultCode: Int, bundle: Bundle) {
    fragmentDelegate.setFragmentResult(resultCode, bundle)
  }

  override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle) {
    fragmentDelegate.onFragmentResult(requestCode, resultCode, data)
  }

  override fun onNewBundle(args: Bundle) {
    fragmentDelegate.onNewBundle(args)
  }

  override fun putNewBundle(newBundle: Bundle) {
    fragmentDelegate.putNewBundle(newBundle)
  }

  //endregion

  //region Soft Input

  override fun hideSoftInput() {
    fragmentDelegate.hideSoftInput()
  }

  override fun showSoftInput(view: View) {
    fragmentDelegate.showSoftInput(view)
  }

  //endregion

  //region Fragment

  override fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView) {
    fragmentDelegate.loadRootFragment(containerId, toFragment)
  }

  override fun loadRootFragment(
    containerId: Int, toFragment: LimboFragmentView, addToBackStack: Boolean, allowAnimation: Boolean) {
    fragmentDelegate.loadRootFragment(containerId, toFragment, addToBackStack, allowAnimation)
  }

  override fun loadMultipleRootFragment(containerId: Int, showPosition: Int, vararg toFragments: LimboFragmentView) {
    fragmentDelegate.loadMultipleRootFragment(containerId, showPosition, *toFragments)
  }

  override fun start(toFragment: LimboFragmentView) {
    fragmentDelegate.start(toFragment)
  }

  override fun start(toFragment: LimboFragmentView, @LaunchMode launchMode: Int) {
    fragmentDelegate.start(toFragment, launchMode)
  }

  override fun startForResult(toFragment: LimboFragmentView, requestCode: Int) {
    fragmentDelegate.startForResult(toFragment, requestCode)
  }

  override fun startWithPop(toFragment: LimboFragmentView) {
    fragmentDelegate.startWithPop(toFragment)
  }

  override fun startWithPopTo(toFragment: LimboFragmentView, targetFragmentClass: Class<*>,
    includeTargetFragment: Boolean) {
    fragmentDelegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
  }

  override fun replaceFragment(toFragment: LimboFragmentView, addToBackStack: Boolean) {
    fragmentDelegate.replaceFragment(toFragment, addToBackStack)
  }

  override fun showHideFragment(showFragment: LimboFragmentView) {
    fragmentDelegate.showHideFragment(showFragment)
  }

  override fun showHideFragment(showFragment: LimboFragmentView, hideFragment: LimboFragmentView) {
    fragmentDelegate.showHideFragment(showFragment, hideFragment)
  }

  override fun pop() {
    fragmentDelegate.pop()
  }

  override fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
    fragmentDelegate.popTo(targetFragmentClass, includeTargetFragment)
  }

  override fun <T : LimboFragmentView> findChildFragment(fragmentClass: Class<T>): T? =
    SupportHelper.findFragment(childFragmentManager, fragmentClass)

  override fun <T : LimboFragmentView> getParentFragment(fragmentClass: Class<T>): T {
    if (parentFragment == null || parentFragment?.javaClass != fragmentClass) {
      throw IllegalArgumentException("Parent fragment at given class does not belong to back stack.")
    }
    return parentFragment as T
  }

  //endregion

  //region Activity

  override fun <T : LimboFragmentActivityView> getActivity(activityClass: Class<T>): T {
    if (activity == null || activity?.javaClass != activityClass) {
      throw IllegalArgumentException("Activity at given class does not host current fragment.")
    }
    return activity as T
  }

  //endregion
}
