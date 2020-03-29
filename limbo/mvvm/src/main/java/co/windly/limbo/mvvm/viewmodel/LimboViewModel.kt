package co.windly.limbo.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class LimboViewModel : ViewModel() {

  //region Disposables

  protected val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  protected open fun clearDisposables() =
    disposables.clear()

  //endregion

  //region Lifecycle

  override fun onCleared() {

    // Clear disposables.
    clearDisposables()

    // Proceed with View Model clearing.
    super.onCleared()
  }

  //endregion
}
