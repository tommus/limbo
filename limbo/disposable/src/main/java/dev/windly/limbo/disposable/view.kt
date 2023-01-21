package dev.windly.limbo.disposable

import android.view.View

/**
 * Lazily creates a view composite disposable that calls dispose method
 * on view's being detached from the window.
 */
fun View.viewCompositeDisposable(): Lazy<ViewCompositeDisposable> =
  lazy { ViewCompositeDisposable(this) }
