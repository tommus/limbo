package co.windly.limbosample.presentation.splash;

import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivityPresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;

class SplashPresenter extends LimboActivityPresenter<SplashView> {

  //region Automatic Continue

  public static Long AUTO_CONTINUE_DELAY = 3_000L;

  void observeAutomaticContinue() {

    addDisposable(
      Observable.timer(AUTO_CONTINUE_DELAY, TimeUnit.MILLISECONDS)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          this::handleObserveAutomaticContinueSuccess,
          this::handleObserveAutomaticContinueError));
  }

  private void handleObserveAutomaticContinueSuccess(@NonNull Long delay) {

    // Log the fact.
    Timber.v("Automatic continue time passed: %d", delay);
    Timber.v("Navigating to main view.");

    // Navigate to main view.
    ifViewAttached(SplashView::navigateToMainView);
  }

  private void handleObserveAutomaticContinueError(@NonNull Throwable throwable) {

    // Log an error.
    Timber.e("An error occurred while processing the automatic continue delay.");
    Timber.e(throwable);

    // Navigate to main view anyway.
    ifViewAttached(SplashView::navigateToMainView);
  }

  //endregion
}
