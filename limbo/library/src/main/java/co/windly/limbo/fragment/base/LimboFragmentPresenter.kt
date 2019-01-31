package co.windly.limbo.fragment.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboFragmentPresenter<V : LimboFragmentView> : MvpBasePresenter<V>() {

  //region Reactive

  protected val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  fun clearDisposables() {
    disposables.clear()
  }

  //endregion
}
