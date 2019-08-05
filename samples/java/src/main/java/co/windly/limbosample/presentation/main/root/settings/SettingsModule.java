package co.windly.limbosample.presentation.main.root.settings;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SettingsModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract SettingsFragment contibuteAndroidInjector();

  //endregion
}
