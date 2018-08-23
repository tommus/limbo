package co.windly.limbo.fragment.base;

import android.content.Context;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public abstract class LimboFragmentPresenter<V extends LimboFragmentView> extends MvpBasePresenter<V> {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  //endregion

  //region Managers

  public void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion

  //region Detach

  public void clearDisposables() {
    disposables.clear();
  }

  //endregion
}
