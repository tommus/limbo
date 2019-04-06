package co.windly.limbosample.application

import android.app.Application

class LimboSample : Application(), ApplicationComponent.ComponentProvider {

  //region Component

  override lateinit var applicationComponent: ApplicationComponent

  //endregion

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    // Initialize dependency graph.
    initializeDependencyInjection()
  }

  //endregion

  //region Dependency Injection

  private fun initializeDependencyInjection() {

    // Initialize application component.
    applicationComponent = DaggerApplicationComponent.builder()
      .with(this)
      .build()
    applicationComponent.inject(this)
  }

  //endregion
}
