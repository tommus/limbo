package co.windly.limbosample.presentation.splash;

import androidx.annotation.NonNull;
import co.windly.limbo.presenter.queue.LimboQueuePresenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

class SplashPresenter extends LimboQueuePresenter<SplashView> {

  //region Constructor

  @Inject
  public SplashPresenter() {
    // No-op.
  }

  //endregion

  //region Lifecycle

  @Override
  public void attachView(@NotNull SplashView view) {
    super.attachView(view);

    // Observe automatic continue.
    observeAutomaticContinue();
  }

  //endregion

  //region Automatic Continue

  @SuppressWarnings("FieldCanBeLocal")
  private static Long AUTO_CONTINUE_DELAY = 3_000L;

  private void observeAutomaticContinue() {
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
    onceViewAttached(SplashView::navigateToMainView);
  }

  private void handleObserveAutomaticContinueError(@NonNull Throwable throwable) {

    // Log an error.
    Timber.e("An error occurred while processing the automatic continue delay.");
    Timber.e(throwable);

    // Navigate to main view anyway.
    onceViewAttached(SplashView::navigateToMainView);
  }

  //endregion
}
