package co.windly.limbosample.application

import android.content.Context
import co.windly.limbosample.R
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

  //region Application Context

  @Provides
  @Singleton
  internal fun provideApplicationContext(application: LimboSample): Context =
    application.also {

      // https://stackoverflow.com/a/2119625/2057291
      it.setTheme(R.style.LimboTheme)
    }

  //endregion
}
