package co.windly.limbosample.presentation.base.activity.fragment;

import android.os.Bundle;
import co.windly.limbo.activity.fragment.LimboFragmentActivity;
import co.windly.limbo.activity.fragment.LimboFragmentActivityView;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;
import org.jetbrains.annotations.Nullable;

public abstract class BaseFragmentActivity<V extends LimboFragmentActivityView, P extends LimboQueuePresenter<V>>
  extends LimboFragmentActivity<V, P> implements LimboFragmentActivityView, HasAndroidInjector {

  //region Fragment Injector

  @Inject
  protected DispatchingAndroidInjector<Object> androidInjector;

  @Override
  public AndroidInjector<Object> androidInjector() {
    return androidInjector;
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
