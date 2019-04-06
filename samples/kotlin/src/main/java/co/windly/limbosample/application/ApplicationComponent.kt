package co.windly.limbosample.application

import co.windly.limbosample.presentation.PresentationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PresentationModule::class])
interface ApplicationComponent {

  //region Injection

  fun inject(application: LimboSample)

  //endregion

  //region Component Builder

  @Component.Builder
  interface Builder {

    fun build(): ApplicationComponent
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    val applicationComponent: ApplicationComponent
  }

  //endregion
}
