package co.windly.limbo.mvp

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface LimboPresenter<V : LimboView> : MvpPresenter<V> {

  //region Reactive

  val disposables: CompositeDisposable

  fun addDisposable(disposable: Disposable): Boolean

  fun clearDisposables()

  //endregion
}
