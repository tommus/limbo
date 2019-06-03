package co.windly.limbosample.presentation.base.activity.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import co.windly.limbo.LimboView
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbo.presenter.queue.LimboQueuePresenter
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseFragmentActivity<V : LimboView, P : LimboQueuePresenter<V>> :
  LimboActivity<V, P>(), LimboView, HasSupportFragmentInjector {

  //region Fragment Injector

  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

  override fun supportFragmentInjector(): AndroidInjector<Fragment> =
    fragmentInjector

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {

    // Inject dependencies.
    AndroidInjection.inject(this)

    super.onCreate(savedInstanceState)
  }

  //endregion
}
