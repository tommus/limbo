package co.windly.limbo.activity.fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import co.windly.limbo.R;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbo.fragment.base.LimboFragmentView;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment.LaunchMode;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class LimboFragmentActivity<V extends LimboFragmentActivityView, P extends LimboFragmentActivityPresenter<V>>
  extends LimboActivity<V, P> implements LimboFragmentActivityView {

  //region Ui

  @IdRes
  protected int getFragmentContainerId() {
    return R.id.fragmentContainer;
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    delegate.onCreate(savedInstanceState);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    delegate.onPostCreate(savedInstanceState);
  }

  @Override
  protected void onDestroy() {
    delegate.onDestroy();
    super.onDestroy();
  }

  //endregion

  //region Touch Event

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    return delegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
  }

  //endregion

  //region Back

  @Override
  public void onBackPressed() {
    delegate.onBackPressed();
  }

  @Override
  public void onBackPressedSupport() {
    delegate.onBackPressedSupport();
  }

  //endregion

  //region Fragment Animator

  @Override
  public FragmentAnimator getFragmentAnimator() {
    return delegate.getFragmentAnimator();
  }

  @Override
  public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
    delegate.setFragmentAnimator(fragmentAnimator);
  }

  @Override
  public FragmentAnimator onCreateFragmentAnimator() {
    return delegate.onCreateFragmentAnimator();
  }

  //endregion

  //region Support Activity

  final SupportActivityDelegate delegate = new SupportActivityDelegate(this);

  @Override
  public SupportActivityDelegate getSupportDelegate() {
    return delegate;
  }

  @Override
  public ExtraTransaction extraTransaction() {
    return delegate.extraTransaction();
  }

  @Override
  public void post(Runnable runnable) {
    delegate.post(runnable);
  }

  //endregion

  //region Fragment

  @Override
  public void loadRootFragment(int containerId, @NonNull LimboFragmentView toFragment) {
    delegate.loadRootFragment(containerId, toFragment);
  }

  @Override
  public void start(LimboFragmentView toFragment) {
    delegate.start(toFragment);
  }

  @Override
  public void start(LimboFragmentView toFragment, @LaunchMode int launchMode) {
    delegate.start(toFragment, launchMode);
  }

  @Override
  public void startWithPopTo(LimboFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment);
  }

  @Override
  public void pop() {
    delegate.pop();
  }

  @Override
  public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.popTo(targetFragmentClass, includeTargetFragment);
  }

  @Override
  public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable) {
    delegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable);
  }

  @Override
  public void popTo(
    Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable, int popAnim) {
    delegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable, popAnim);
  }

  @Override
  public LimboFragmentView getTopFragment() {
    return (LimboFragment) SupportHelper.getTopFragment(getSupportFragmentManager());
  }

  @Override
  public <F extends LimboFragmentView> F findFragment(Class<F> fragmentClass) {
    return SupportHelper.findFragment(getSupportFragmentManager(), fragmentClass);
  }

  //endregion
}
