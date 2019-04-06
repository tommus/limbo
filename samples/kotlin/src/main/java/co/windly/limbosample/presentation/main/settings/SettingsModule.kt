package co.windly.limbosample.presentation.main.settings

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SettingsModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): SettingsFragment

  //endregion
}
