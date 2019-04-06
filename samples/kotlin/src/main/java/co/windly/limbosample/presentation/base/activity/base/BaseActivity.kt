package co.windly.limbosample.presentation.base.activity.base

import android.os.Bundle
import co.windly.limbo.LimboView
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbo.presenter.queue.LimboQueuePresenter
import dagger.android.AndroidInjection

abstract class BaseActivity<V : LimboView, P : LimboQueuePresenter<V>> : LimboActivity<V, P>(), LimboView {

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {

    // Inject dependencies.
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
  }

  //endregion
}
