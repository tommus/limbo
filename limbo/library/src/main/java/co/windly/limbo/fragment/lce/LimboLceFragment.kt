package co.windly.limbo.fragment.lce

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.annotation.LayoutRes
import co.windly.limbo.LimboPresenter
import co.windly.limbo.activity.fragment.LimboFragmentActivityView
import co.windly.limbo.fragment.base.LimboFragmentView
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.anim.FragmentAnimator

abstract class LimboLceFragment<CV : View, M, V : LimboLceFragmentView<M>, P : LimboPresenter<V>> : MvpLceFragment<CV, M, V, P>(), LimboLceFragmentView<M> {

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

  protected val delegate: SupportFragmentDelegate
    by lazy { SupportFragmentDelegate(this) }

  //endregion

  //region Lifecycle

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    delegate.onAttach((context as Activity?)!!)
  }

  override fun onAttach(activity: Activity?) {
    super.onAttach(activity)
    delegate.onAttach(activity!!)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(layout, container, false)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    delegate.onCreate(savedInstanceState)
  }

  override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? =
    delegate.onCreateAnimation(transit, enter, nextAnim)

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    delegate.onActivityCreated(savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    delegate.onSaveInstanceState(outState)
  }

  override fun onResume() {
    super.onResume()
    delegate.onResume()
  }

  override fun onPause() {
    super.onPause()
    delegate.onPause()
  }

  override fun onDestroy() {
    super.onDestroy()
    delegate.onDestroy()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    delegate.onDestroyView()
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
    delegate.onHiddenChanged(hidden)
  }

  override fun setUserVisibleHint(isVisibleToUser: Boolean) {
    super.setUserVisibleHint(isVisibleToUser)
    delegate.setUserVisibleHint(isVisibleToUser)
  }

  //endregion

  //region Back

  override fun onBackPressedSupport(): Boolean =
    delegate.onBackPressedSupport()

  //endregion

  //region Fragment Animator

  override fun onCreateFragmentAnimator(): FragmentAnimator =
    delegate.onCreateFragmentAnimator()

  override fun getFragmentAnimator(): FragmentAnimator =
    delegate.fragmentAnimator

  override fun setFragmentAnimator(fragmentAnimator: FragmentAnimator) {
    delegate.fragmentAnimator = fragmentAnimator
  }

  override fun getSupportDelegate(): SupportFragmentDelegate =
    delegate

  override fun extraTransaction(): ExtraTransaction =
    delegate.extraTransaction()

  override fun enqueueAction(runnable: Runnable) {
    delegate.enqueueAction(runnable)
  }

  override fun post(runnable: Runnable) {
    delegate.post(runnable)
  }

  override fun onEnterAnimationEnd(savedInstanceState: Bundle?) {
    delegate.onEnterAnimationEnd(savedInstanceState)
  }

  override fun onLazyInitView(savedInstanceState: Bundle?) {
    delegate.onLazyInitView(savedInstanceState)
  }

  override fun onSupportVisible() {
    delegate.onSupportVisible()
  }

  override fun onSupportInvisible() {
    delegate.onSupportInvisible()
  }

  override fun isSupportVisible(): Boolean =
    delegate.isSupportVisible

  override fun setFragmentResult(resultCode: Int, bundle: Bundle) {
    delegate.setFragmentResult(resultCode, bundle)
  }

  override fun onFragmentResult(requestCode: Int, resultCode: Int, data: Bundle) {
    delegate.onFragmentResult(requestCode, resultCode, data)
  }

  override fun onNewBundle(args: Bundle) {
    delegate.onNewBundle(args)
  }

  override fun putNewBundle(newBundle: Bundle) {
    delegate.putNewBundle(newBundle)
  }

  //endregion

  //region Soft Input

  override fun hideSoftInput() {
    delegate.hideSoftInput()
  }

  override fun showSoftInput(view: View) {
    delegate.showSoftInput(view)
  }

  //endregion

  //region Fragment

  override fun loadRootFragment(containerId: Int, toFragment: LimboFragmentView) {
    delegate.loadRootFragment(containerId, toFragment)
  }

  override fun loadRootFragment(
    containerId: Int, toFragment: LimboFragmentView, addToBackStack: Boolean, allowAnimation: Boolean) {
    delegate.loadRootFragment(containerId, toFragment, addToBackStack, allowAnimation)
  }

  override fun loadMultipleRootFragment(containerId: Int, showPosition: Int, vararg toFragments: LimboFragmentView) {
    delegate.loadMultipleRootFragment(containerId, showPosition, *toFragments)
  }

  override fun start(toFragment: LimboFragmentView) {
    delegate.start(toFragment)
  }

  override fun start(toFragment: LimboFragmentView, @LaunchMode launchMode: Int) {
    delegate.start(toFragment, launchMode)
  }

  override fun startForResult(toFragment: LimboFragmentView, requestCode: Int) {
    delegate.startForResult(toFragment, requestCode)
  }

  override fun startWithPop(toFragment: LimboFragmentView) {
    delegate.startWithPop(toFragment)
  }

  override fun startWithPopTo(toFragment: LimboFragmentView, targetFragmentClass: Class<*>,
    includeTargetFragment: Boolean) {
    delegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment)
  }

  override fun replaceFragment(toFragment: LimboFragmentView, addToBackStack: Boolean) {
    delegate.replaceFragment(toFragment, addToBackStack)
  }

  override fun showHideFragment(showFragment: LimboFragmentView) {
    delegate.showHideFragment(showFragment)
  }

  override fun showHideFragment(showFragment: LimboFragmentView, hideFragment: LimboFragmentView) {
    delegate.showHideFragment(showFragment, hideFragment)
  }

  override fun pop() {
    delegate.pop()
  }

  override fun popTo(targetFragmentClass: Class<*>, includeTargetFragment: Boolean) {
    delegate.popTo(targetFragmentClass, includeTargetFragment)
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
