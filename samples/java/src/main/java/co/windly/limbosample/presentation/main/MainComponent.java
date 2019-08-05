package co.windly.limbosample.presentation.main;

import co.windly.limbosample.presentation.main.root.RootModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {
  RootModule.class
})
public interface MainComponent extends AndroidInjector<MainActivity> {

  //region Factory

  @Subcomponent.Factory
  interface Factory extends AndroidInjector.Factory<MainActivity> {
    // No-op.
  }

  //endregion
}
