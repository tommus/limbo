package co.windly.limbo.activity.lce

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import co.windly.limbo.LimboPresenter
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboLceActivity<CV : View, M, V : LimboLceActivityView<M>, P : LimboPresenter<V>> : MvpLceActivity<CV, M, V, P>(), LimboLceActivityView<M> {

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
    setContentView(layout)
  }

  override fun onDestroy() {

    // Clear presenter-bound disposables.
    getPresenter().clearDisposables()

    // Clear view-bound disposables.
    clearDisposables()

    super.onDestroy()
  }

  //endregion
}
