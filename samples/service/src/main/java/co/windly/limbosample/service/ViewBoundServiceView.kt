package co.windly.limbosample.service

import co.windly.limbo.LimboServiceView

interface ViewBoundServiceView : LimboServiceView {

  //region Layout

  /**
   * A place for view inflation and configuration.
   */
  fun initializeView()

  /**
   * A place for view cleanup.
   */
  fun destroyView()

  //endregion

  //region Floating Action

  fun initializeFloatingActionListener()

  fun snapToTop()

  fun snapToBottom()

  //endregion

  //region Card

  fun toggleCard()

  //endregion
}
