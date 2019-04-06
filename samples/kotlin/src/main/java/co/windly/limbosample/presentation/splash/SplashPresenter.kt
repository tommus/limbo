package co.windly.limbosample.presentation.splash

import co.windly.limbo.presenter.queue.LimboQueuePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit.MILLISECONDS
import javax.inject.Inject

class SplashPresenter @Inject constructor() : LimboQueuePresenter<SplashView>() {

  //region Lifecycle

  override fun attachView(view: SplashView) {
    super.attachView(view)

    // Observe automatic continue.
    observeAutomaticContinue()
  }

  //endregion

  //region Automatic Continue

  companion object {
    const val AUTO_CONTINUE_DELAY = 3_000L
  }

  private fun observeAutomaticContinue() {
    Observable
      .timer(AUTO_CONTINUE_DELAY, MILLISECONDS)
      .subscribeOn(Schedulers.computation())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        ::handleObserveAutomaticContinueSuccess,
        ::handleObserveAutomaticContinueError
      )
      .addTo(disposables)
  }

  private fun handleObserveAutomaticContinueSuccess(delay: Long) = onceViewAttached {

    // Log the fact.
    Timber.v("Automatic continue time passed: %d", delay)
    Timber.v("Navigating to main view.")

    // Navigate to main view.
    it.navigateToMainView()
  }

  private fun handleObserveAutomaticContinueError(throwable: Throwable) = onceViewAttached {

    // Log an error.
    Timber.e("An error occurred while processing the automatic continue delay.")
    Timber.e(throwable)

    // Navigate to main view anyway.
    it.navigateToMainView()
  }

  //endregion
}
