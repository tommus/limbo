package co.windly.limbosample.presentation.main;

import co.windly.limbo.activity.fragment.LimboFragmentActivityView;

interface MainView extends LimboFragmentActivityView {

  //region Navigation

  void navigateToHomeView();

  void navigateToSettingsView();

  //endregion
}
