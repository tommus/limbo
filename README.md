# Limbo
[![Maven Central][mavenbadge-svg]][mavencentral] [![Travis (.org) branch][travisci-svg]][travisci] [![API][apibadge-svg]][apioverview] [![GitHub][license-svg]][license]

This library composes Android Navigation Component and Mosby to simplify creation of MVP and fragment-based Android application.

### Usage

### Add dependencies

Add dependencies to Java or Kotlin-based project:

```groovy
dependencies {
    implementation "co.windly:limbo:2.2.0"
}
```

Optionally, you can add one of utility packages to your project:

```groovy
dependencies {
    implementation "co.windly:limbo-disposable:2.2.0"
    implementation "co.windly:limbo-utility:2.2.0"
    implementation "co.windly:limbo-utility:2.2.0"
}
```

### Use based classes to accomplish MVP driven architecture

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

## Samples

Please do not hesitate to check `samples` directory for simple examples how to use `Limbo` in Java and Kotlin projects.

## License

    Copyright 2019 Tomasz Dzieniak

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[apibadge-svg]: https://img.shields.io/badge/API-21%2B-brightgreen.svg?color=97ca00
[apioverview]: https://developer.android.com/about/versions/android-5.0
[license-svg]: https://img.shields.io/github/license/tommus/limbo.svg?color=97ca00
[license]: http://www.apache.org/licenses/LICENSE-2.0
[mavenbadge-svg]: https://img.shields.io/maven-central/v/co.windly/limbo.svg?color=97ca00
[mavencentral]: https://search.maven.org/artifact/co.windly/limbo
[travisci-svg]: https://img.shields.io/travis/tommus/limbo/master.svg?color=97ca00
[travisci]: https://travis-ci.org/tommus/limbo
