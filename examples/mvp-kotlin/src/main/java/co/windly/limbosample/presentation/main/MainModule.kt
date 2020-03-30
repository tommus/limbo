package co.windly.limbosample.presentation.main

import co.windly.limbosample.presentation.main.MainComponent.Factory
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [
  MainComponent::class
])
abstract class MainModule {

  //region Binding

  @Binds
  @IntoMap
  @ClassKey(MainActivity::class)
  abstract fun bindAndroidInjectorFactory(factory: Factory): AndroidInjector.Factory<*>

  //endregion
}
