package co.windly.limbosample.presentation.splash

import co.windly.limbo.LimboView

interface SplashView : LimboView {

  //region Navigation

  fun startViewBoundService()

  fun stopViewBoundService()

  //endregion
}
