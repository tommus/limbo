### Use base classes to accomplish MVP driven architecture

Example view for activity:

```kotlin
interface SplashView : LimboView {

  //region Navigation

  fun navigateToMainView()

  //endregion
}
```

Example presenter for activity:

```kotlin
class SplashPresenter : LimboQueuePresenter<SplashView>() {

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

    Observable.timer(AUTO_CONTINUE_DELAY, MILLISECONDS)
        .subscribeOnComputation()
        .observeOnUi()
        .subscribe(
            { this.handleObserveAutomaticContinueSuccess(it) },
            { this.handleObserveAutomaticContinueError(it) }
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
```

Example activity:

```kotlin
class SplashActivity : LimboActivity<SplashView, SplashPresenter>(), SplashView {

  //region Ui

  override val layout: Int
    get() = R.layout.activity_splash

  //endregion

  //region Presenter

  // TODO: Inject presenter. Eg. using Dagger.
  override fun createPresenter(): SplashPresenter =
    SplashPresenter()

  //endregion

  //region Navigation

  override fun navigateToMainView() {

    // Prepare intent.
    val intent = MainActivity.createIntent(this)

    // Start activity.
    startActivity(intent)
  }

  //endregion
}
```
