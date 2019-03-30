package co.windly.limbo

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

interface LimboView : MvpView {

  //region Reactive

  val disposables: CompositeDisposable

  fun addDisposable(disposable: Disposable): Boolean

  fun clearDisposables()

  //endregion
}
