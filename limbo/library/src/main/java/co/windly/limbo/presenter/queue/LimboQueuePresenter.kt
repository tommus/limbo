package co.windly.limbo.presenter.queue

import co.windly.limbo.LimboPresenter
import co.windly.limbo.LimboView
import com.hannesdorfmann.mosby3.mvp.MvpQueuingBasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboQueuePresenter<V : LimboView> : MvpQueuingBasePresenter<V>(), LimboPresenter<V> {

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
