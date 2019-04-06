package co.windly.limbosample.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.WindowManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentationModule {

  //region Layout Inflater

  @Provides
  @Singleton
  fun provideLayoutInflater(context: Context): LayoutInflater =
    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

  //endregion

  //region Window Manager

  @Provides
  @Singleton
  fun provideWindowManager(context: Context): WindowManager =
    context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

  //endregion
}
