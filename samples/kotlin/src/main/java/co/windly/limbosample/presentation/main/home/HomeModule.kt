package co.windly.limbosample.presentation.main.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): HomeFragment

  //endregion
}
