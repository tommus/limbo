package co.windly.limbo.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class LimboViewModel : ViewModel() {

  /**
   * Holds view model-bound disposables and offers O(1) add and removal
   * complexity.
   */
  protected val disposables = CompositeDisposable()

  /**
   * Clears fragment-bound disposables.
   */
  protected open fun clearDisposables() {
    disposables.clear()
  }

  override fun onCleared() {
    super.onCleared()
    clearDisposables()
  }
}
