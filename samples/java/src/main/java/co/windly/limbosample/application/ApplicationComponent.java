package co.windly.limbosample.application;

import co.windly.limbosample.presentation.PresentationModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = { PresentationModule.class })
interface ApplicationComponent {

  //region Injection

  void inject(LimboSample application);

  //endregion

  //region Component Builder

  @Component.Builder
  interface Builer {

    ApplicationComponent build();
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    ApplicationComponent getApplicationComponent();
  }

  //endregion
}
