package dev.windly.limbo.utility.reactive

import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.disposables.DisposableContainer

/**
 * Adds given [Disposable] to [DisposableContainer].
 */
fun Disposable.addTo(composite: DisposableContainer): Disposable =
  apply { composite.add(this) }
