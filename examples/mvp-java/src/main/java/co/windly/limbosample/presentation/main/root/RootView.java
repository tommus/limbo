package co.windly.limbosample.presentation.main.root;

import co.windly.limbo.mvp.fragment.base.LimboFragmentView;

public interface RootView extends LimboFragmentView {

  //region Navigation

  void navigateToHomeView();

  void navigateToSettingsView();

  //endregion
}
