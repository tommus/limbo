package co.windly.limbosample.presentation.base.activity.base;

import android.os.Bundle;
import co.windly.limbo.LimboView;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import dagger.android.AndroidInjection;
import org.jetbrains.annotations.Nullable;

public abstract class BaseActivity<V extends LimboView, P extends LimboQueuePresenter<V>> extends LimboActivity<V, P>
  implements LimboView {

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {

    // Inject dependencies.
    AndroidInjection.inject(this);

    super.onCreate(savedInstanceState);
  }

  //endregion
}
