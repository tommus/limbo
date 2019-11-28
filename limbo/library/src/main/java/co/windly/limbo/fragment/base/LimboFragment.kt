package co.windly.limbo.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import co.windly.limbo.LimboPresenter
import co.windly.limbo.disposable.LifecycleCompositeDisposable
import co.windly.limbo.disposable.lifecycleDestroyCompositeDisposable
import com.hannesdorfmann.mosby3.mvp.MvpFragment
import io.reactivex.disposables.Disposable

abstract class LimboFragment<V : LimboFragmentView, P : LimboPresenter<V>> : MvpFragment<V, P>(), LimboFragmentView {

  //region Reactive

  override val disposables: LifecycleCompositeDisposable
    by lifecycleDestroyCompositeDisposable()

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Ui

  @get:LayoutRes
  protected abstract val layout: Int

  //endregion

  //region Lifecycle

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
    inflater.inflate(layout, container, false)

  override fun onDestroy() {

    // Clear presenter-bound disposables.
    getPresenter().clearDisposables()

    // Continue destroy'ing fragment.
    super.onDestroy()
  }

  //endregion
}
