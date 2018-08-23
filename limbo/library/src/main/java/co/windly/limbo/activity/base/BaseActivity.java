package co.windly.limbo.activity.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;

public abstract class BaseActivity<V extends BaseActivityView, P extends BaseActivityPresenter<V>> extends MvpActivity<V, P>
  implements BaseActivityView {

  //region Ui

  @LayoutRes
  protected abstract int getLayout();

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayout());
    initializeViews();
    getPresenter().initializeManagers(this);
  }

  @Override
  protected void onDestroy() {
    getPresenter().clearDisposables();
    super.onDestroy();
  }

  //endregion

  //region View Injection

  protected void initializeViews() {
    ButterKnife.bind(this);
  }

  //endregion
}
