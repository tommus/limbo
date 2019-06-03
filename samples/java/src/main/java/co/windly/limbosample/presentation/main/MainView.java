package co.windly.limbosample.presentation.main;

import co.windly.limbo.LimboView;

interface MainView extends LimboView {

  //region Navigation

  void navigateToHomeView();

  void navigateToSettingsView();

  //endregion
}
