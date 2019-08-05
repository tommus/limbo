package co.windly.limbosample.presentation.base.activity.base

import android.os.Bundle
import co.windly.limbo.LimboView
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbo.presenter.queue.LimboQueuePresenter
import dagger.Lazy
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<V : LimboView, P : LimboQueuePresenter<V>> : LimboActivity<V, P>(), LimboView,
  HasAndroidInjector {

  //region Android Injector

  @Inject
  lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> =
    androidInjector

  //endregion

  //region Presenter

  @Inject
  lateinit var activityPresenter: Lazy<P>

  override fun createPresenter(): P =
    activityPresenter.get()

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {

    // Inject dependencies.
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
  }

  //endregion
}
