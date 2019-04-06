package co.windly.limbo.service

import co.windly.limbo.LimboPresenter
import co.windly.limbo.LimboServiceView

interface LimboServicePresenter<V : LimboServiceView> : LimboPresenter<V> {

  /**
   * Provides an instance of the view.
   */
  fun provideView(): V

  /**
   * Executes given lambda view on behalf of attached view.
   */
  fun ifViewAttached(lambda: (V) -> Unit)
}
