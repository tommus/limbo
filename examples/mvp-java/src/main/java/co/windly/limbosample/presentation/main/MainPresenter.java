package co.windly.limbosample.presentation.main;

import co.windly.limbo.mvp.presenter.queue.LimboQueuePresenter;
import javax.inject.Inject;

class MainPresenter extends LimboQueuePresenter<MainView> {

  //region Constructor

  @Inject
  MainPresenter() {
    // No-op.
  }

  //endregion
}
