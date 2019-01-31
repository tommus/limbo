package co.windly.limbo.activity.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.hannesdorfmann.mosby3.mvp.MvpActivity

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
}
