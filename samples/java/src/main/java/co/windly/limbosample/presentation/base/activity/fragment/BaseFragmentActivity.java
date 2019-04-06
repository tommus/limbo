package co.windly.limbosample.presentation.base.activity.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import co.windly.limbo.activity.fragment.LimboFragmentActivity;
import co.windly.limbo.activity.fragment.LimboFragmentActivityView;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;
import org.jetbrains.annotations.Nullable;

public abstract class BaseFragmentActivity<V extends LimboFragmentActivityView, P extends LimboQueuePresenter<V>>
  extends LimboFragmentActivity<V, P> implements LimboFragmentActivityView, HasSupportFragmentInjector {

  //region Fragment Injector

  @Inject
  protected DispatchingAndroidInjector<Fragment> fragmentInjector;

  @Override
  public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentInjector;
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    // Inject dependencies.
    AndroidInjection.inject(this);

    super.onCreate(savedInstanceState);
  }

  //endregion
}
