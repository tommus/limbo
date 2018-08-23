package co.windly.limbo.fragment.base;

import android.os.Bundle;
import android.view.View;
import co.windly.limbo.activity.fragment.BaseFragmentActivityView;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import me.yokeyword.fragmentation.ISupportFragment;

public interface BaseFragmentView extends MvpView, ISupportFragment {

  //region Soft Input

  void hideSoftInput();

  void showSoftInput(final View view);

  //endregion

  //region Fragment

  void loadRootFragment(int containerId, BaseFragmentView toFragment);

  void loadRootFragment(int containerId, BaseFragmentView toFragment, boolean addToBackStack, boolean allowAnimation);

  void loadMultipleRootFragment(int containerId, int showPosition, BaseFragmentView... toFragments);

  void start(BaseFragmentView toFragment);

  void start(final BaseFragmentView toFragment, @BaseFragmentView.LaunchMode int launchMode);

  void startForResult(BaseFragmentView toFragment, int requestCode);

  void setFragmentResult(int resultCode, Bundle bundle);

  void startWithPop(BaseFragmentView toFragment);

  void startWithPopTo(BaseFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment);

  void replaceFragment(BaseFragmentView toFragment, boolean addToBackStack);

  void showHideFragment(BaseFragmentView showFragment);

  void showHideFragment(BaseFragmentView showFragment, BaseFragmentView hideFragment);

  void pop();

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment);

  <T extends BaseFragmentView> T findChildFragment(Class<T> fragmentClass);

  @SuppressWarnings("unchecked")
  <T extends BaseFragmentView> T getParentFragment(Class<T> fragmentClass);

  //endregion

  //region Activity

  <T extends BaseFragmentActivityView> T getActivity(Class<T> activityClass);

  //endregion
}
