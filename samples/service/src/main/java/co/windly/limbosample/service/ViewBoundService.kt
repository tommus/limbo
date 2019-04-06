package co.windly.limbosample.service

import co.windly.limbo.service.LimboService
import co.windly.limbosample.application.LimboSample
import javax.inject.Inject

class ViewBoundService : LimboService<ViewBoundServiceView>(), ViewBoundComponent.ComponentProvider {

  //region Component

  override lateinit var viewBoundComponent: ViewBoundComponent

  //endregion

  //region View

  @Inject
  lateinit var viewBound: ViewBound

  override fun provideView(): ViewBoundServiceView =
    viewBound

  //endregion

  //region Lifecycle

  override fun onCreate() {

    // Initialize dependency graph.
    initializeDependencyInjection()

    super.onCreate()
  }

  override fun onDestroy() {
    super.onDestroy()


  }

  //endregion

  //region Dependency Injection

  private fun initializeDependencyInjection() {

    // Initialize view bound component.
    viewBoundComponent = (application as LimboSample).applicationComponent
      .viewBoundBuilder()
      .with(this)
      .build()
    viewBoundComponent.inject(this)
  }

  //endregion

  //region Floating Action

  fun onFloatingActionButtonClicked() = ifViewAttached {

    // Toggle card visibility.
    it.toggleCard()
  }

  //endregion
}
