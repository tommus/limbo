package co.windly.limbosample.presentation.main;

import co.windly.limbosample.presentation.main.home.HomeModule;
import co.windly.limbosample.presentation.main.settings.SettingsModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
  HomeModule.class,
  SettingsModule.class
})
public interface MainComponent extends AndroidInjector<MainActivity> {

  //region Builder

  @Subcomponent.Factory
  interface Factory extends AndroidInjector.Factory<MainActivity> {
    // No-op.
  }

  //endregion
}
