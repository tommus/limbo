package co.windly.limbosample.presentation.main.root;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface RootComponent extends AndroidInjector<RootFragment> {

  //region Factory

  @Subcomponent.Factory
  interface Factory extends AndroidInjector.Factory<RootFragment> {
    // No-op.
  }

  //endregion
}
