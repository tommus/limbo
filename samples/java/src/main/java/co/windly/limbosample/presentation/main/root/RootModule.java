package co.windly.limbosample.presentation.main.root;

import co.windly.limbosample.presentation.main.root.home.HomeModule;
import co.windly.limbosample.presentation.main.root.settings.SettingsModule;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = { RootComponent.class },
  includes = {
    HomeModule.class,
    SettingsModule.class
  }
)
public abstract class RootModule {

  //region Binding

  @Binds
  @IntoMap
  @ClassKey(RootFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(RootComponent.Factory factory);

  //endregion
}
