package co.windly.limbosample.presentation.main.root

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface RootComponent : AndroidInjector<RootFragment> {

  //region Factory

  @Subcomponent.Factory
  interface Factory : AndroidInjector.Factory<RootFragment>

  //endregion
}
