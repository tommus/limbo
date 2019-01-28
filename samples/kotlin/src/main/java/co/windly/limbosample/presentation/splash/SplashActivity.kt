package co.windly.limbosample.presentation.splash

import android.os.Bundle
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbosample.R
import co.windly.limbosample.presentation.main.MainActivity

class SplashActivity : LimboActivity<SplashView, SplashPresenter>(), SplashView {

  //region Ui

  override fun getLayout(): Int =
      R.layout.activity_splash

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
