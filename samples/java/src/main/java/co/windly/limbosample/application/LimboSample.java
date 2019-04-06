package co.windly.limbosample.application;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

public class LimboSample extends Application implements ApplicationComponent.ComponentProvider, HasActivityInjector {

  //region Activity Injector

  @Inject
  protected DispatchingAndroidInjector<Activity> activityInjector;

  @Override
  public AndroidInjector<Activity> activityInjector() {
    return activityInjector;
  }

  //endregion

  //region Component

  private ApplicationComponent applicationComponent;

  @Override
  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  //endregion

  //region Lifecycle

  @Override
  public void onCreate() {
    super.onCreate();

    // Initialize dependency graph.
    initializeDependencyInjection();
  }

  //endregion

  //region Dependency Injection

  private void initializeDependencyInjection() {

    // Initialize application component.
    applicationComponent = DaggerApplicationComponent.builder()
      .build();
    applicationComponent.inject(this);
  }

  //endregion
}
