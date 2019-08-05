package co.windly.limbo

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
