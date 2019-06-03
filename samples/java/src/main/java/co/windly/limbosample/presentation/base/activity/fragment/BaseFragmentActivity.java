package co.windly.limbosample.presentation.base.activity.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import co.windly.limbo.LimboView;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;
import org.jetbrains.annotations.Nullable;

public abstract class BaseFragmentActivity<V extends LimboView, P extends LimboQueuePresenter<V>>
  extends LimboActivity<V, P> implements LimboView, HasSupportFragmentInjector {

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
