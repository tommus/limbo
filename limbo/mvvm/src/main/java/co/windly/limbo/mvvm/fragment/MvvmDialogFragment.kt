package co.windly.limbo.mvvm.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import co.windly.limbo.mvvm.trait.ContextTrait
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import co.windly.limbo.mvvm.trait.FragmentTrait
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class MvvmDialogFragment<Binding : ViewDataBinding, VM : LimboViewModel> : DialogFragment(),
  ContextTrait, FragmentTrait, FragmentNavigationTrait {

  //region Disposables

  protected open val disposables: CompositeDisposable
    by lazy { CompositeDisposable() }

  protected open fun clearDisposables() =
    disposables.clear()

  //endregion

  //region UI

  @get:LayoutRes
  abstract val layoutRes: Int

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

  override val contextTrait: Context
    get() = requireContext()

  override val fragmentTrait: Fragment
    get() = this

  override val navigationTrait: Fragment
    get() = this

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Retain instance.
    retainInstance = true
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    // Inflate binding.
    binding = DataBindingUtil
      .inflate(inflater, layoutRes, container, false)

    // Attach lifecycle owner.
    binding.lifecycleOwner = this

    // Initialize binding.
    bindView(binding)

    // Return bound view.
    return binding.root
  }

  override fun onDestroy() {
    super.onDestroy()

    // Clear disposables.
    clearDisposables()
  }

  //endregion
}
