package co.windly.limbosample.presentation.main;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = { MainComponent.class })
public abstract class MainModule {

  //region Binding

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(MainComponent.Builder builder);

  //endregion
}
