package co.windly.limbosample.presentation.splash;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SplashModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract SplashActivity contibuteAndroidInjector();

  //endregion
}
