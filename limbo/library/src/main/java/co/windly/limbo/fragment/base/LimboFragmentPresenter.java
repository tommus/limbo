package co.windly.limbo.fragment.base;

import android.content.Context;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class LimboFragmentPresenter<V extends LimboFragmentView> extends MvpBasePresenter<V> {

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

  public void initializeManagers(@NonNull Context context) {
    // No-op.
  }

  //endregion
}
