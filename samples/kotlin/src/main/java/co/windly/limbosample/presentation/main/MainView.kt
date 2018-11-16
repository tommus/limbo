package co.windly.limbosample.presentation.main

import co.windly.limbo.activity.fragment.LimboFragmentActivityView

interface MainView : LimboFragmentActivityView {

  //region Navigation

  fun navigateToHomeView()

  fun navigateToSettingsView()

  //endregion
}
