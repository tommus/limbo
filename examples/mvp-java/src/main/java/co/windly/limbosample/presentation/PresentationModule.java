package co.windly.limbosample.presentation;

import co.windly.limbosample.presentation.main.MainModule;
import co.windly.limbosample.presentation.splash.SplashModule;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = {
  AndroidSupportInjectionModule.class,
  SplashModule.class,
  MainModule.class
})
public class PresentationModule {
  // No-op.
}
