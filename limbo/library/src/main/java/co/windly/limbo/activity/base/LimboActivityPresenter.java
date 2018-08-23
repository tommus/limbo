package co.windly.limbo.activity.base;

import android.content.Context;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;

public abstract class LimboActivityPresenter<View extends LimboActivityView> extends MvpBasePresenter<View> {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  //endregion

  //region Managers

  protected void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion

  //region Clear

  protected void clearDisposables() {
    disposables.clear();
  }

  //endregion
}
