# Limbo

This library composes Fragmentation and Mosby to simplify creation of MVP and fragment-based Android application.

### Usage

1. Add dependencies.

Add dependencies to Java or Kotlin-based project:

```groovy
dependencies {
    implementation "co.windly:limbo:0.8.2"
}
```

2. Use based classes to accomplish MVP driven architecture.

Example view for activity:

```kotlin
interface SplashView : LimboActivityView {

  //region Navigation

  fun navigateToMainView()

  //endregion
}
```

Example presenter for activity:

```kotlin
class SplashPresenter : LimboActivityPresenter<SplashView>() {

  //region Automatic Continue

  companion object {
    const val AUTO_CONTINUE_DELAY = 3_000L
  }

  fun observeAutomaticContinue() {

    Observable.timer(AUTO_CONTINUE_DELAY, MILLISECONDS)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            { this.handleObserveAutomaticContinueSuccess(it) },
            { this.handleObserveAutomaticContinueError(it) }
        )
        .addTo(disposables)
  }

  private fun handleObserveAutomaticContinueSuccess(delay: Long) {

    // Log the fact.
    Timber.v("Automatic continue time passed: %d", delay)
    Timber.v("Navigating to main view.")

    // Navigate to main view.
    ifViewAttached { it.navigateToMainView() }
  }

  private fun handleObserveAutomaticContinueError(throwable: Throwable) {

    // Log an error.
    Timber.e("An error occurred while processing the automatic continue delay.")
    Timber.e(throwable)

    // Navigate to main view anyway.
    ifViewAttached { it.navigateToMainView() }
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

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Start counting the automatic continue timer.
    getPresenter().observeAutomaticContinue()
  }

  //endregion
}
```

### Samples

Please do not hesitate to check `samples` directory for simple examples how to use `Limbo` in Java and Kotlin projects.
