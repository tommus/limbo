package co.windly.limbosample.service

import dagger.BindsInstance
import dagger.Subcomponent

@ViewBoundScope
@Subcomponent(modules = [ViewBoundModule::class])
interface ViewBoundComponent {

  //region Injection

  fun inject(service: ViewBoundService)

  //endregion

  //region Component Builder

  @Subcomponent.Builder
  interface Builder {

    @BindsInstance
    fun with(service: ViewBoundService): Builder

    fun build(): ViewBoundComponent
  }

  //endregion

  //region Component Provider

  interface ComponentProvider {

    val viewBoundComponent: ViewBoundComponent
  }

  //endregion
}
