package co.windly.limbosample.presentation.splash

import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.activity.base.BaseActivity
import co.windly.limbosample.presentation.main.MainActivity

class SplashActivity : BaseActivity<SplashView, SplashPresenter>(), SplashView {

  //region Ui

  override val layout: Int
    get() = R.layout.activity_splash

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
