package co.windly.limbosample.application

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LimboSample : Application(), ApplicationComponent.ComponentProvider, HasAndroidInjector {

  //region Activity Injector

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  //endregion

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
      .build()
    applicationComponent.inject(this)
  }

  //endregion
}
