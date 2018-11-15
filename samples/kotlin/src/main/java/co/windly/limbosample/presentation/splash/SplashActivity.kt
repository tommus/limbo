package co.windly.limbosample.presentation.splash

import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbosample.R

class SplashActivity : LimboActivity<SplashView, SplashPresenter>(), SplashView {

  //region Ui

  override fun getLayout() = R.layout.activity_splash

  //endregion

  //region Presenter

  override fun createPresenter() = SplashPresenter()

  //endregion
}
