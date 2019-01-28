package co.windly.limbo.fragment.base;

import android.os.Bundle;
import android.view.View;
import co.windly.limbo.activity.fragment.LimboFragmentActivityView;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import me.yokeyword.fragmentation.ISupportFragment;

public interface LimboFragmentView extends MvpView, ISupportFragment {

  //region Soft Input

  void hideSoftInput();

  void showSoftInput(final View view);

  //endregion

  //region Fragment

  void loadRootFragment(int containerId, LimboFragmentView toFragment);

  void loadRootFragment(int containerId, LimboFragmentView toFragment, boolean addToBackStack, boolean allowAnimation);

  void loadMultipleRootFragment(int containerId, int showPosition, LimboFragmentView... toFragments);

  void start(LimboFragmentView toFragment);

  void start(final LimboFragmentView toFragment, @LimboFragmentView.LaunchMode int launchMode);

  void startForResult(LimboFragmentView toFragment, int requestCode);

  void setFragmentResult(int resultCode, Bundle bundle);

  void startWithPop(LimboFragmentView toFragment);

  void startWithPopTo(LimboFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment);

  void replaceFragment(LimboFragmentView toFragment, boolean addToBackStack);

  void showHideFragment(LimboFragmentView showFragment);

  void showHideFragment(LimboFragmentView showFragment, LimboFragmentView hideFragment);

  void pop();

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment);

  <T extends LimboFragmentView> T findChildFragment(Class<T> fragmentClass);

  @SuppressWarnings("unchecked")
  <T extends LimboFragmentView> T getParentFragment(Class<T> fragmentClass);

  //endregion

  //region Activity

  <T extends LimboFragmentActivityView> T getActivity(Class<T> activityClass);

  //endregion
}
