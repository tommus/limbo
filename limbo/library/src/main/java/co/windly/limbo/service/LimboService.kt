package co.windly.limbo.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.annotation.NonNull
import co.windly.limbo.LimboServiceView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class LimboService<V : LimboServiceView> : Service(), LimboServicePresenter<V> {

  //region Threading

  override val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  override fun addDisposable(@NonNull disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Binding

  override fun onBind(intent: Intent?): IBinder? =
    null

  //endregion

  //region View

  private var viewReference: WeakReference<V>? =
    null

  /**
   * {@inheritDoc}
   */
  override fun attachView(view: V) {
    viewReference = WeakReference(view)
  }

  override fun detachView(unsupported: Boolean) {
    detachView()
  }

  /**
   * {@inheritDoc}
   */
  override fun detachView() {
    viewReference?.clear()
    viewReference = null
  }

  /**
   * {@inheritDoc}
   */
  override fun destroy() {

    // Notify view that it should be destroyed.
    viewReference?.get()?.onDestroy()

    // Detach view.
    detachView()
  }

  /**
   * {@inheritDoc}
   */
  override fun ifViewAttached(lambda: (V) -> Unit) {

    // Retrieve view.
    val view = viewReference?.get()

    // Execute lambda if view is not null.
    if (view != null) {
      lambda(view)
    }
  }

  //endregion

  //region Lifecycle

  override fun onCreate() {
    super.onCreate()

    // Provide view.
    val view = provideView()

    // Call view's onCreate() method.
    view.onCreate()

    // Attach view.
    attachView(view)
  }

  override fun onDestroy() {

    // Clear disposables.
    clearDisposables()

    // Destroy view.
    destroy()

    super.onDestroy()
  }

  //endregion
}
