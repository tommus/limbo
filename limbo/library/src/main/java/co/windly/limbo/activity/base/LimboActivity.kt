package co.windly.limbo.activity.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import co.windly.limbo.LimboPresenter
import co.windly.limbo.LimboView
import co.windly.limbo.disposable.LifecycleCompositeDisposable
import co.windly.limbo.disposable.lifecycleDestroyCompositeDisposable
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import io.reactivex.disposables.Disposable

abstract class LimboActivity<V : LimboView, P : LimboPresenter<V>> : MvpActivity<V, P>(), LimboView {

  //region Reactive

  override val disposables: LifecycleCompositeDisposable
    by lifecycleDestroyCompositeDisposable()

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

    // Continue destroy'ing activity.
    super.onDestroy()
  }

  //endregion
}
