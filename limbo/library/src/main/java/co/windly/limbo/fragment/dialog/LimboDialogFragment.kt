package co.windly.limbo.fragment.dialog

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import co.windly.limbo.LimboPresenter
import co.windly.limbo.activity.fragment.LimboFragmentActivityView
import co.windly.limbo.fragment.base.LimboFragmentView
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.yokeyword.fragmentation.ExtraTransaction
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportFragmentDelegate
import me.yokeyword.fragmentation.SupportHelper
import me.yokeyword.fragmentation.anim.FragmentAnimator

abstract class LimboDialogFragment<V : LimboFragmentView, P : LimboPresenter<V>> : DialogFragment(), MvpDelegateCallback<V, P>, LimboFragmentView {

  //region Reactive

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Delegate

  val mvpDelegate: FragmentMvpDelegate<V, P>
    by lazy { FragmentMvpDelegateImpl(this, this, true, true) }

  //endregion

  //region Ui

  @get:LayoutRes
  protected abstract val layout: Int

  //endregion

  //region Presenter

  protected var mvpPresenter: P? =
    null

  override fun getPresenter(): P =
    requireNotNull(mvpPresenter)

  override fun setPresenter(presenter: P) {
    mvpPresenter = presenter
  }

  abstract override fun createPresenter(): P

  //endregion

  //region Support Fragment

  protected val delegate: SupportFragmentDelegate
    by lazy { SupportFragmentDelegate(this) }

  //endregion

  //region View

  override fun getMvpView(): V =
    this as V

  //endregion

  //region Lifecycle

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(layout, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mvpDelegate.onViewCreated(view, savedInstanceState)
  }

  override fun onDestroyView() {
    super.onDestroyView()
    mvpDelegate.onDestroyView()
    delegate.onDestroyView()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mvpDelegate.onCreate(savedInstanceState)
    delegate.onCreate(savedInstanceState)
  }

  override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation? =
    delegate.onCreateAnimation(transit, enter, nextAnim)

  override fun onDestroy() {
    super.onDestroy()
    mvpDelegate.onDestroy()
    delegate.onDestroy()
  }

  override fun onPause() {
    super.onPause()
    mvpDelegate.onPause()
    delegate.onPause()
  }

  override fun onResume() {
    super.onResume()
    mvpDelegate.onResume()
    delegate.onResume()
  }

  override fun onStart() {
    super.onStart()
    mvpDelegate.onStart()
  }

  override fun onStop() {
    super.onStop()
    mvpDelegate.onStop()
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    mvpDelegate.onActivityCreated(savedInstanceState)
    delegate.onActivityCreated(savedInstanceState)
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    mvpDelegate.onAttach(context as Activity?)
    delegate.onAttach(context)
  }

  override fun onAttach(activity: Activity) {
    super.onAttach(activity)
    mvpDelegate.onAttach(activity)
    delegate.onAttach(activity)
  }

  override fun onDetach() {

    // Clear presenter-bound disposables.
    getPresenter().clearDisposables()

    //Clear view-bound disposables.
    clearDisposables()

    super.onDetach()

    mvpDelegate.onDetach()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    mvpDelegate.onSaveInstanceState(outState)
    delegate.onSaveInstanceState(outState)
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

  override fun start(toFragment: LimboFragmentView, @ISupportFragment.LaunchMode launchMode: Int) {
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
