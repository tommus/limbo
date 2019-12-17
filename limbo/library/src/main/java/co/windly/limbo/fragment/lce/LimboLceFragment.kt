package co.windly.limbo.fragment.lce

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import co.windly.limbo.LimboPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboLceFragment<CV : View, M, V : LimboLceFragmentView<M>, P : LimboPresenter<V>> :
  MvpLceFragment<CV, M, V, P>(), LimboLceFragmentView<M> {

  //region Reactive

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

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

    // Clear view-bound disposables.
    clearDisposables()

    // Continue destroy'ing fragment.
    super.onDestroy()
  }

  //endregion
}
