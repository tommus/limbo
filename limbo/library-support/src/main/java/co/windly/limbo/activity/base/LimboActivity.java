package co.windly.limbo.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

public abstract class LimboActivity<V extends LimboActivityView, P extends LimboActivityPresenter<V>>
  extends MvpActivity<V, P>
  implements LimboActivityView {

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    getPresenter().initializeManagers(this);
  }

  @Override
  protected void onDestroy() {
    getPresenter().clearDisposables();
    super.onDestroy();
  }

  //endregion
}
