package co.windly.limbo

import co.windly.limbo.disposable.LifecycleCompositeDisposable
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.Disposable

interface LimboView : MvpView {

  //region Reactive

  val disposables: LifecycleCompositeDisposable

  fun addDisposable(disposable: Disposable): Boolean

  fun clearDisposables()

  //endregion
}
