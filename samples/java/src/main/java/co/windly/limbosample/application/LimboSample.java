package co.windly.limbosample.application;

import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;

public class LimboSample extends Application implements ApplicationComponent.ComponentProvider, HasAndroidInjector {

  //region Activity Injector

  @Inject
  protected DispatchingAndroidInjector<Object> androidInjector;
  private ApplicationComponent applicationComponent;

  //endregion

  //region Component

  @Override
  public AndroidInjector<Object> androidInjector() {
    return androidInjector;
  }

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
