package co.windly.limbosample.presentation.base.fragment.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import butterknife.ButterKnife;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbo.fragment.base.LimboFragmentView;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.Lazy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("WeakerAccess")
public abstract class BaseFragment<V extends LimboFragmentView, P extends LimboQueuePresenter<V>>
  extends LimboFragment<V, P> implements LimboFragmentView, HasAndroidInjector {

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

  @Nullable
  @Override
  public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container,
    @Nullable Bundle savedInstanceState) {

    // Create view.
    final View view = super.onCreateView(inflater, container, savedInstanceState);

    // Throw an exception if view cannot be inflated.
    if (view == null) {
      throw new IllegalStateException("Unable to inflate view.");
    }

    // Bind views.
    ButterKnife.bind(this, view);

    // Return created view.
    return view;
  }

  //endregion
}
