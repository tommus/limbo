package co.windly.limbo.mvvm.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class DaggerMvvmActivity<Binding : ViewDataBinding, VM : LimboViewModel> :
  MvvmActivity<Binding, VM>(), HasAndroidInjector {

  //region Injector

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Inject dependencies.
    AndroidInjection.inject(this)
  }

  //endregion
}
