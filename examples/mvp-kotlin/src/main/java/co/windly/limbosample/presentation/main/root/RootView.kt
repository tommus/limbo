package co.windly.limbosample.presentation.main.root

import co.windly.limbo.mvp.fragment.base.LimboFragmentView

interface RootView : LimboFragmentView {

  //region Navigation

  fun navigateToHomeView()

  fun navigateToSettingsView()

  //endregion
}
