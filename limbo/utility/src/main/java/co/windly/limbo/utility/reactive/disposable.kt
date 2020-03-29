package co.windly.limbo.utility.reactive

import io.reactivex.disposables.Disposable
import io.reactivex.internal.disposables.DisposableContainer

/**
 * Adds given disposable to disposable container.
 */
fun Disposable.addTo(composite: DisposableContainer): Disposable =
  apply { composite.add(this) }
