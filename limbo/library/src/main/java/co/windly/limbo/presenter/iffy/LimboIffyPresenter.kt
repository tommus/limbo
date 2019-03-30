package co.windly.limbo.presenter.iffy

import co.windly.limbo.LimboPresenter
import co.windly.limbo.LimboView
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboIffyPresenter<V : LimboView> : MvpBasePresenter<V>(), LimboPresenter<V> {

  //region Reactive

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion
}
