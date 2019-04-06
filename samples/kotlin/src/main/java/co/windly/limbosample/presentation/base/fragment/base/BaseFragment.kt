package co.windly.limbosample.presentation.base.fragment.base

import android.content.Context
import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbo.fragment.base.LimboFragmentView
import co.windly.limbo.presenter.queue.LimboQueuePresenter
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<V : LimboFragmentView, P : LimboQueuePresenter<V>> : LimboFragment<V, P>(), LimboFragmentView {

  //region Lifecycle

  override fun onAttach(context: Context?) {

    // Inject dependencies.
    AndroidSupportInjection.inject(this)

    super.onAttach(context)
  }

  //endregion
}
