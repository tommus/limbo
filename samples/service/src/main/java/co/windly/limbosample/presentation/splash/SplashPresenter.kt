package co.windly.limbosample.presentation.splash

import co.windly.limbo.presenter.queue.LimboQueuePresenter

class SplashPresenter : LimboQueuePresenter<SplashView>() {

  //region Service

  fun onStartServiceButtonClicked() = onceViewAttached {

    // Start service.
    it.startViewBoundService()
  }

  fun onStopServiceButtonClicked() = onceViewAttached {

    // Stop service.
    it.stopViewBoundService()
  }

  //endregion
}
