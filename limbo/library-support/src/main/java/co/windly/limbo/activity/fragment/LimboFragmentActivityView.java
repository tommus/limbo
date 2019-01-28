package co.windly.limbo.activity.fragment;

import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivityView;
import co.windly.limbo.fragment.base.LimboFragmentView;
import me.yokeyword.fragmentation.ISupportActivity;

public interface LimboFragmentActivityView extends LimboActivityView, ISupportActivity {

  //region Fragment

  void loadRootFragment(int containerId, @NonNull LimboFragmentView toFragment);

  void start(LimboFragmentView toFragment);

  void start(LimboFragmentView toFragment, @LimboFragmentView.LaunchMode int launchMode);

  void startWithPopTo(LimboFragmentView toFragment, Class<?> targetFragmentClass, boolean includeTargetFragment);

  void pop();

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment);

  void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable);

  void popTo(
    Class<?> targetFragmentClass, boolean includeTargetFragment, Runnable afterPopTransactionRunnable, int popAnim);

  LimboFragmentView getTopFragment();

  <F extends LimboFragmentView> F findFragment(Class<F> fragmentClass);

  //endregion
}
