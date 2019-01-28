package co.windly.limbosample.presentation.main.settings;

import androidx.annotation.NonNull;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbosample.R;

public class SettingsFragment extends LimboFragment<SettingsView, SettingsPresenter> implements SettingsView {

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

  //region Presenter

  @NonNull
  @Override
  public SettingsPresenter createPresenter() {

    // TODO: Inject presenter. Eg. using Dagger.
    return new SettingsPresenter();
  }

  //endregion
}
