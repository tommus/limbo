package co.windly.limbo.activity.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class LimboActivity<V : LimboActivityView, P : LimboActivityPresenter<V>> : MvpActivity<V, P>(), LimboActivityView {

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
    getPresenter().clearDisposables()
    super.onDestroy()
  }

  //endregion

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
