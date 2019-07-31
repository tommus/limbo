package co.windly.limbosample.presentation.main.settings;

import androidx.annotation.NonNull;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;
import javax.inject.Inject;

public class SettingsFragment extends BaseFragment<SettingsView, SettingsPresenter> implements SettingsView {

  //region Fragment

  @Inject
  @SuppressWarnings("WeakerAccess")
  protected SettingsPresenter settingsPresenter;

  //endregion

  //region Ui

  public static SettingsFragment createInstance() {
    return new SettingsFragment();
  }

  //endregion

  //region Presenter

  @Override
  protected int getLayout() {
    return R.layout.fragment_settings;
  }

  @NonNull
  @Override
  public SettingsPresenter createPresenter() {
    return settingsPresenter;
  }

  //endregion
}
