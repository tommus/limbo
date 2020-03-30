package co.windly.limbosample.presentation.base.fragment.base

import android.content.Context
import co.windly.limbo.mvp.fragment.base.LimboFragment
import co.windly.limbo.mvp.fragment.base.LimboFragmentView
import co.windly.limbo.mvp.presenter.queue.LimboQueuePresenter
import dagger.Lazy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<V : LimboFragmentView, P : LimboQueuePresenter<V>> : LimboFragment<V, P>(),
  LimboFragmentView, HasAndroidInjector {

  //region Android Injector

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  //endregion

  //region Presenter

  @Inject
  lateinit var fragmentPresenter: Lazy<P>

  override fun createPresenter(): P =
    fragmentPresenter.get()

  //endregion

  //region Lifecycle

  override fun onAttach(context: Context) {

    // Inject dependencies.
    AndroidSupportInjection.inject(this)

    super.onAttach(context)
  }

  //endregion
}
