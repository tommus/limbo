package co.windly.limbosample.presentation.main

import co.windly.limbosample.presentation.main.home.HomeModule
import co.windly.limbosample.presentation.main.settings.SettingsModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [
  HomeModule::class,
  SettingsModule::class
])
interface MainComponent : AndroidInjector<MainActivity> {

  //region Builder

  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<MainActivity>()

  //endregion
}
