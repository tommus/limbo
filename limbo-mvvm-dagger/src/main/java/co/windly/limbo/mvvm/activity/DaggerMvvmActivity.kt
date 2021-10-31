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

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  override fun onCreate(savedInstanceState: Bundle?) {

    // Inject dependencies.
    AndroidInjection.inject(this)

    // Continue initialization.
    super.onCreate(savedInstanceState)
  }
}
