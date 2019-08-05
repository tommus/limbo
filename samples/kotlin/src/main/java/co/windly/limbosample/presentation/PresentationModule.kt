package co.windly.limbosample.presentation

import co.windly.limbosample.presentation.main.MainModule
import co.windly.limbosample.presentation.splash.SplashModule
import dagger.Module
import dagger.android.AndroidInjectionModule

@Module(includes = [
  AndroidInjectionModule::class,
  MainModule::class,
  SplashModule::class
])
class PresentationModule
