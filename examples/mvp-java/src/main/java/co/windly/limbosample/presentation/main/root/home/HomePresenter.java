package co.windly.limbosample.presentation.main.root.home;

import co.windly.limbo.mvp.presenter.queue.LimboQueuePresenter;
import javax.inject.Inject;

class HomePresenter extends LimboQueuePresenter<HomeView> {

  //region Constructor

  @Inject
  HomePresenter() {
    // No-op.
  }

  //endregion
}
