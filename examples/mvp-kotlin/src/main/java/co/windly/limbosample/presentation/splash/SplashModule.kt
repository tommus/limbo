package co.windly.limbosample.presentation.splash

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): SplashActivity

  //endregion
}
