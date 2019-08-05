package co.windly.limbosample.presentation.base.fragment.base;

import android.content.Context;
import androidx.annotation.NonNull;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbo.fragment.base.LimboFragmentView;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.Lazy;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment<V extends LimboFragmentView, P extends LimboQueuePresenter<V>>
  extends LimboFragment<V, P> implements LimboFragmentView {

  //region Presenter

  @Inject
  @SuppressWarnings("WeakerAccess")
  protected Lazy<P> fragmentPresenter;

  @NonNull
  @Override
  public P createPresenter() {
    return fragmentPresenter.get();
  }

  //endregion

  //region Lifecycle

  @Override
  public void onAttach(@NotNull Context context) {

    // Inject dependencies.
    AndroidSupportInjection.inject(this);

    super.onAttach(context);
  }

  //endregion
}
