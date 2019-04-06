package co.windly.limbo.service

import co.windly.limbo.LimboServiceView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboServiceView<V : LimboServiceView, P : LimboServicePresenter<V>> : LimboServiceView {

  //region Reactive

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Lifecycle

  override fun onCreate() {

    // Create presenter.
    _presenter = createPresenter()
  }

  override fun onDestroy() {

    // Clear view-bound disposables.
    clearDisposables()
  }

  //endregion

  //region Presenter

  protected lateinit var _presenter: P

  abstract fun createPresenter(): P

  fun getPresenter(): P =
    _presenter

  //endregion
}
