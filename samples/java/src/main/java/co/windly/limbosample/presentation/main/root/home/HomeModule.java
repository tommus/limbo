package co.windly.limbosample.presentation.main.root.home;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class HomeModule {

  //region Contribution

  @ContributesAndroidInjector
  abstract HomeFragment contibuteAndroidInjector();

  //endregion
}
