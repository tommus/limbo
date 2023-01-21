package dev.windly.limbo.mvvm.fragment

import android.content.Context
import androidx.databinding.ViewDataBinding
import dev.windly.limbo.mvvm.viewmodel.LimboViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class DaggerMvvmFragment<Binding : ViewDataBinding, VM : LimboViewModel> :
  MvvmFragment<Binding, VM>(), HasAndroidInjector {

  //region Injector

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  //endregion

  //region Lifecycle

  override fun onAttach(context: Context) {
    super.onAttach(context)

    // Inject dependencies.
    AndroidSupportInjection.inject(this)
  }

  //endregion
}
