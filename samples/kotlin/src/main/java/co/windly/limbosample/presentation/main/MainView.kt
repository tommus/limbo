package co.windly.limbosample.presentation.main

import co.windly.limbo.LimboView

interface MainView : LimboView {

  //region Navigation

  fun navigateToHomeView()

  fun navigateToSettingsView()

  //endregion
}
