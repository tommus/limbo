package co.windly.limbo.mvvm.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import co.windly.limbo.mvvm.trait.ActivityNavigationTrait
import co.windly.limbo.mvvm.trait.ContextTrait
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class MvvmActivity<Binding : ViewDataBinding, VM : LimboViewModel> : AppCompatActivity(),
  ActivityNavigationTrait, ContextTrait {

  //region Disposables

  protected open val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  protected open fun clearDisposables() =
    disposables.clear()

  //endregion

  //region Ui

  @get:LayoutRes
  abstract val layoutResId: Int

  //endregion

  //region View Model

  @Inject
  lateinit var factory: ViewModelProvider.Factory

  abstract val viewModel: VM

  //endregion

  //region Binding

  protected open lateinit var binding: Binding

  abstract fun bindView(binding: Binding)

  //endregion

  //region Trait

  override val activityTrait: Activity
    get() = this

  override val contextTrait: Context
    get() = this

  override val navigationTrait: Activity
    get() = this

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Configure layout.
    binding =
      DataBindingUtil.setContentView(this, layoutResId)

    // Initialize binding.
    bindView(binding)
  }

  override fun onDestroy() {
    super.onDestroy()

    // Clear disposables.
    clearDisposables()
  }

  //endregion
}
