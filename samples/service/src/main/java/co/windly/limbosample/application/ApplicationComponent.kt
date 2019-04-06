package co.windly.limbosample.application

import co.windly.limbosample.presentation.PresentationModule
import co.windly.limbosample.service.ViewBoundComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
  ApplicationModule::class,
  PresentationModule::class
])
interface ApplicationComponent {

  //region Injection

  fun inject(application: LimboSample)

  //endregion

  //region Component Builder

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun with(application: LimboSample): Builder

    fun build(): ApplicationComponent
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    val applicationComponent: ApplicationComponent
  }

  //endregion

  //region Exposition

  fun viewBoundBuilder(): ViewBoundComponent.Builder

  //endregion
}
