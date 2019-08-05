package co.windly.limbosample.presentation.main.settings;

import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;

public class SettingsFragment extends BaseFragment<SettingsView, SettingsPresenter> implements SettingsView {

  //region Fragment

  public static SettingsFragment createInstance() {
    return new SettingsFragment();
  }

  //endregion

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.fragment_settings;
  }

  //endregion
}
