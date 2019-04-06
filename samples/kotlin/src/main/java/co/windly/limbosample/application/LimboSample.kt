package co.windly.limbosample.application

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class LimboSample : Application(), ApplicationComponent.ComponentProvider, HasActivityInjector {

  //region Activity Injector

  @Inject
  lateinit var activityInjector: DispatchingAndroidInjector<Activity>

  override fun activityInjector(): AndroidInjector<Activity> =
    activityInjector

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
