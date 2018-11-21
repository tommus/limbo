package co.windly.limbo.fragment.dialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import co.windly.limbo.activity.fragment.LimboFragmentActivityView;
import co.windly.limbo.fragment.base.LimboFragmentView;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportFragmentDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public abstract class LimboDialogFragment<V extends LimboDialogFragmentView, P extends LimboDialogFragmentPresenter<V>>
  extends DialogFragment implements MvpDelegateCallback<V, P>, LimboDialogFragmentView {

  //region Delegate

  protected FragmentMvpDelegate<V, P> mvpDelegate;

  @NonNull
  protected FragmentMvpDelegate<V, P> getMvpDelegate() {
    if (mvpDelegate == null) {
      mvpDelegate = new FragmentMvpDelegateImpl<>(this, this, true, true);
    }

    return mvpDelegate;
  }

  //endregion

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  @CallSuper
  protected void initializeView(@NonNull View view, @Nullable Bundle savedInstanceState) {
    ButterKnife.bind(this, view);
  }

  //endregion

  //region Presenter

  protected P presenter;

  @NonNull
  public abstract P createPresenter();

  @Override
  public P getPresenter() {
    return presenter;
  }

  @Override
  public void setPresenter(P presenter) {
    this.presenter = presenter;
  }

  //endregion

  //region View

  @Override
  public V getMvpView() {
    return (V) this;
  }

  //endregion

  //region Lifecycle

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState) {
    final View view = inflater.inflate(getLayout(), container, false);
    initializeView(view, savedInstanceState);
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getMvpDelegate().onViewCreated(view, savedInstanceState);
    getPresenter().initializeManagers(requireContext());
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    getMvpDelegate().onDestroyView();
    delegate.onDestroyView();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getMvpDelegate().onCreate(savedInstanceState);
    delegate.onCreate(savedInstanceState);
  }

  @Override
  public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
    return delegate.onCreateAnimation(transit, enter, nextAnim);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    getMvpDelegate().onDestroy();
    delegate.onDestroy();
  }

  @Override
  public void onPause() {
    super.onPause();
    getMvpDelegate().onPause();
    delegate.onPause();
  }

  @Override
  public void onResume() {
    super.onResume();
    getMvpDelegate().onResume();
    delegate.onResume();
  }

  @Override
  public void onStart() {
    super.onStart();
    getMvpDelegate().onStart();
  }

  @Override
  public void onStop() {
    super.onStop();
    getMvpDelegate().onStop();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getMvpDelegate().onActivityCreated(savedInstanceState);
    delegate.onActivityCreated(savedInstanceState);
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    getMvpDelegate().onAttach((Activity) context);
    delegate.onAttach((Activity) context);
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    getMvpDelegate().onAttach(activity);
    delegate.onAttach(activity);
  }

  @Override
  public void onDetach() {
    getPresenter().clearDisposables();
    super.onDetach();
    getMvpDelegate().onDetach();
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    getMvpDelegate().onSaveInstanceState(outState);
    delegate.onSaveInstanceState(outState);
  }

  @Override
  public void onHiddenChanged(boolean hidden) {
    super.onHiddenChanged(hidden);
    delegate.onHiddenChanged(hidden);
  }

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    delegate.setUserVisibleHint(isVisibleToUser);
  }

  //endregion

  //region Back

  @Override
  public boolean onBackPressedSupport() {
    return delegate.onBackPressedSupport();
  }

  //endregion

  //region Fragment Animator

  @Override
  public FragmentAnimator onCreateFragmentAnimator() {
    return delegate.onCreateFragmentAnimator();
  }

  @Override
  public FragmentAnimator getFragmentAnimator() {
    return delegate.getFragmentAnimator();
  }

  @Override
  public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
    delegate.setFragmentAnimator(fragmentAnimator);
  }

  //endregion

  //region Support Fragment

  final SupportFragmentDelegate delegate = new SupportFragmentDelegate(this);

  @Override
  public SupportFragmentDelegate getSupportDelegate() {
    return delegate;
  }

  @Override
  public ExtraTransaction extraTransaction() {
    return delegate.extraTransaction();
  }

  @Override
  @Deprecated
  public void enqueueAction(Runnable runnable) {
    delegate.enqueueAction(runnable);
  }

  @Override
  public void post(Runnable runnable) {
    delegate.post(runnable);
  }

  @Override
  public void onEnterAnimationEnd(@Nullable Bundle savedInstanceState) {
    delegate.onEnterAnimationEnd(savedInstanceState);
  }

  @Override
  public void onLazyInitView(@Nullable Bundle savedInstanceState) {
    delegate.onLazyInitView(savedInstanceState);
  }

  @Override
  public void onSupportVisible() {
    delegate.onSupportVisible();
  }

  @Override
  public void onSupportInvisible() {
    delegate.onSupportInvisible();
  }

  @Override
  public boolean isSupportVisible() {
    return delegate.isSupportVisible();
  }

  @Override
  public void setFragmentResult(int resultCode, Bundle bundle) {
    delegate.setFragmentResult(resultCode, bundle);
  }

  @Override
  public void onFragmentResult(int requestCode, int resultCode, Bundle data) {
    delegate.onFragmentResult(requestCode, resultCode, data);
  }

  @Override
  public void onNewBundle(Bundle args) {
    delegate.onNewBundle(args);
  }

  @Override
  public void putNewBundle(Bundle newBundle) {
    delegate.putNewBundle(newBundle);
  }

  //endregion

  //region Soft Input

  @Override
  public void hideSoftInput() {
    delegate.hideSoftInput();
  }

  @Override
  public void showSoftInput(final View view) {
    delegate.showSoftInput(view);
  }

  //endregion

  //region Fragment

  @Override
  public void loadRootFragment(int containerId, LimboFragmentView toFragment) {
    delegate.loadRootFragment(containerId, toFragment);
  }

  @Override
  public void loadRootFragment(
    int containerId, LimboFragmentView toFragment, boolean addToBackStack, boolean allowAnimation) {
    delegate.loadRootFragment(containerId, toFragment, addToBackStack, allowAnimation);
  }

  @Override
  public void loadMultipleRootFragment(int containerId, int showPosition, LimboFragmentView... toFragments) {
    delegate.loadMultipleRootFragment(containerId, showPosition, toFragments);
  }

  @Override
  public void start(LimboFragmentView toFragment) {
    delegate.start(toFragment);
  }

  @Override
  public void start(final LimboFragmentView toFragment, @ISupportFragment.LaunchMode int launchMode) {
    delegate.start(toFragment, launchMode);
  }

  @Override
  public void startForResult(LimboFragmentView toFragment, int requestCode) {
    delegate.startForResult(toFragment, requestCode);
  }

  @Override
  public void startWithPop(LimboFragmentView toFragment) {
    delegate.startWithPop(toFragment);
  }

  @Override
  public void startWithPopTo(LimboFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment) {
    delegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment);
  }

  @Override
  public void replaceFragment(LimboFragmentView toFragment, boolean addToBackStack) {
    delegate.replaceFragment(toFragment, addToBackStack);
  }

  @Override
  public void showHideFragment(LimboFragmentView showFragment) {
    delegate.showHideFragment(showFragment);
  }

  @Override
  public void showHideFragment(LimboFragmentView showFragment, LimboFragmentView hideFragment) {
    delegate.showHideFragment(showFragment, hideFragment);
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
  public <T extends LimboFragmentView> T findChildFragment(Class<T> fragmentClass) {
    return SupportHelper.findFragment(getChildFragmentManager(), fragmentClass);
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LimboFragmentView> T getParentFragment(Class<T> fragmentClass) {
    final Fragment fragment = getParentFragment();
    if (fragment == null || !fragment.getClass().equals(fragmentClass)) {
      throw new IllegalArgumentException("Parent fragment at given class does not belong to back stack.");
    }
    return (T) fragment;
  }

  //endregion

  //region Activity

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LimboFragmentActivityView> T getActivity(Class<T> activityClass) {
    final Activity activity = getActivity();
    if (activity == null || !activity.getClass().equals(activityClass)) {
      throw new IllegalArgumentException("Activity at given class does not host current fragment.");
    }
    return (T) activity;
  }

  //endregion
}
