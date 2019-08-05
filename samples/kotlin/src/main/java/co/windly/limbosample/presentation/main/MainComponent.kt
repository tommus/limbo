package co.windly.limbosample.presentation.main

import co.windly.limbosample.presentation.main.root.RootModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [
  RootModule::class
])
interface MainComponent : AndroidInjector<MainActivity> {

  //region Builder

  @Subcomponent.Factory
  interface Factory : AndroidInjector.Factory<MainActivity>

  //endregion
}
