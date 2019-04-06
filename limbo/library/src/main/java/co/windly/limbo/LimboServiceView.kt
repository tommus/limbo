package co.windly.limbo

import co.windly.limbo.LimboView

interface LimboServiceView : LimboView {

  //region Lifecycle

  /**
   * Will be called during Service.onCreate().
   */
  fun onCreate()

  /**
   * Will be called during Service.onDestroy().
   */
  fun onDestroy()

  //endregion
}
