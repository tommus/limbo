package co.windly.limbosample.presentation.base.activity.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import butterknife.ButterKnife;
import co.windly.limbo.mvp.LimboView;
import co.windly.limbo.mvp.activity.base.LimboActivity;
import co.windly.limbo.mvp.presenter.queue.LimboQueuePresenter;
import dagger.Lazy;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;
import org.jetbrains.annotations.Nullable;

public abstract class BaseActivity<V extends LimboView, P extends LimboQueuePresenter<V>> extends LimboActivity<V, P>
  implements LimboView, HasAndroidInjector {

  //region Android Injector

  @Inject
  protected DispatchingAndroidInjector<Object> androidInjector;

  @Override
  public AndroidInjector<Object> androidInjector() {
    return androidInjector;
  }

  //endregion

  //region Presenter

  @Inject
  protected Lazy<P> activityPresenter;

  @NonNull
  @Override
  public P createPresenter() {
    return activityPresenter.get();
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    // Inject dependencies.
    AndroidInjection.inject(this);

    // Bind views.
    ButterKnife.bind(this);

    // Call super.
    super.onCreate(savedInstanceState);
  }

  //endregion
}
