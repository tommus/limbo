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
import co.windly.limbo.mvvm.trait.ContextTrait
import co.windly.limbo.mvvm.trait.FragmentNavigationTrait
import co.windly.limbo.mvvm.trait.FragmentTrait
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class MvvmDialogFragment<
  Binding : ViewDataBinding, VM : LimboViewModel> : DialogFragment(),
  ContextTrait, FragmentTrait, FragmentNavigationTrait {

  /**
   * Holds fragment-bound disposables and offers O(1) add and removal
   * complexity.
   */
  protected open val disposables = CompositeDisposable()

  /**
   * Clears fragment-bound disposables.
   */
  protected open fun clearDisposables() {
    disposables.clear()
  }

  /**
   * Denotes a resource that should be inflated as fragment's layout.
   */
  @get:LayoutRes
  abstract val layoutRes: Int

  /**
   * A reference to view model associated with fragment.
   */
  abstract val viewModel: VM

  /**
   * A view binding associated with given fragment.
   */
  private var _binding: Binding? = null

  /**
   * Allows to access a biding associated with given fragment.
   */
  protected val binding: Binding
    get() = _binding ?: throw IllegalStateException(
      "Binding is not available at this moment of component lifecycle.")

  /**
   * Called at the end of onCreateView(). Can be used to set data bindings.
   */
  abstract fun bindView(binding: Binding)

  /**
   * Holds a weak reference to the context.
   * <p>
   * A part of context trait interface to help trait context-dependant features.
   */
  override val contextTrait: WeakReference<Context>
    get() = WeakReference(requireContext())

  /**
   * Holds a weak reference to the fragment.
   * <p>
   * A part of fragment trait interface to help trait activity-dependant
   * features.
   */
  override val fragmentTrait: WeakReference<Fragment>
    get() = WeakReference(this)

  /**
   * Holds a weak reference to the activity.
   * <p>
   * A part of navigation trait interface to simplify navigation controller
   * implementation.
   */
  override val navigationTrait: WeakReference<Fragment>
    get() = WeakReference(this)

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? {

    _binding = DataBindingUtil.inflate(
      inflater, layoutRes, container, false)

    binding.lifecycleOwner = viewLifecycleOwner
    bindView(binding)

    return binding.root
  }

  override fun onDestroyView() {
    _binding = null
    super.onDestroyView()
  }

  override fun onDestroy() {
    super.onDestroy()
    clearDisposables()
  }
}
