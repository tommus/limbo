package co.windly.limbo.activity.fragment;

import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.BaseActivityView;
import co.windly.limbo.fragment.base.BaseFragmentView;
import me.yokeyword.fragmentation.ISupportActivity;

public interface BaseFragmentActivityView extends BaseActivityView, ISupportActivity {

  //region Fragment

  void loadRootFragment(int containerId, @NonNull BaseFragmentView toFragment);

  void start(BaseFragmentView toFragment);

  void start(BaseFragmentView toFragment, @BaseFragmentView.LaunchMode int launchMode);

  void startWithPopTo(BaseFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment);

  void pop();

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment);

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable);

  void popTo(
    Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable, int popAnim);

  BaseFragmentView getTopFragment();

  <F extends BaseFragmentView> F findFragment(Class<F> fragmentClass);

  //endregion
}
