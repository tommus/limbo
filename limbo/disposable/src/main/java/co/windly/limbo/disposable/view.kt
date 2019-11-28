package co.windly.limbo.disposable

import android.view.View

//region View Detach From Window

/**
 * Lazily creates a view composite disposable that calls dispose method
 * on view's being detached from the window.
 */
fun View.viewCompositeDisposable(): Lazy<ViewCompositeDisposable> =
  lazy {
    ViewCompositeDisposable(this)
  }

//endregion
