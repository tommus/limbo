package co.windly.limbo.activity.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboActivityPresenter<View : LimboActivityView> : MvpBasePresenter<View>() {

  //region Threading

  protected val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  fun clearDisposables() {
    disposables.clear()
  }

  //endregion
}
