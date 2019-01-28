package co.windly.limbo.activity.base;

import android.content.Context;
import android.support.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class LimboActivityPresenter<View extends LimboActivityView> extends MvpBasePresenter<View> {

  //region Threading

  protected CompositeDisposable disposables = new CompositeDisposable();

  public boolean addDisposable(@NonNull Disposable disposable) {
    return disposables.add(disposable);
  }

  public void clearDisposables() {
    disposables.clear();
  }

  //endregion

  //region Managers

  protected void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion
}
