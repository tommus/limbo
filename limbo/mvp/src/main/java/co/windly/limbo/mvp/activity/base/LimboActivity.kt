package co.windly.limbo.mvp.activity.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import co.windly.limbo.mvp.LimboPresenter
import co.windly.limbo.mvp.LimboView
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboActivity<V : LimboView, P : LimboPresenter<V>> : MvpActivity<V, P>(), LimboView {

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

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Define content view.
    setContentView(layout)
  }

  override fun onDestroy() {

    // Clear presenter-bound disposables.
    getPresenter().clearDisposables()

    // Clear view-bound disposables.
    clearDisposables()

    // Continue destroy'ing activity.
    super.onDestroy()
  }

  //endregion
}
