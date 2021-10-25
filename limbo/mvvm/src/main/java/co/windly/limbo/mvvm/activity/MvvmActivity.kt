package co.windly.limbo.mvvm.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import co.windly.limbo.mvvm.trait.ActivityNavigationTrait
import co.windly.limbo.mvvm.trait.ContextTrait
import co.windly.limbo.mvvm.viewmodel.LimboViewModel
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class MvvmActivity<Binding : ViewDataBinding, VM : LimboViewModel> :
  AppCompatActivity(), ActivityNavigationTrait, ContextTrait {

  /**
   * Holds activity-bound disposables and offers O(1) add and removal
   * complexity.
   */
  protected open val disposables = CompositeDisposable()

  /**
   * Clears activity-bound disposables.
   */
  protected open fun clearDisposables() {
    disposables.clear()
  }

  /**
   * Denotes a resource that should be inflated as activity's layout.
   */
  @get:LayoutRes
  abstract val layoutResId: Int

  /**
   * A reference to view model associated with activity.
   */
  abstract val viewModel: VM

  /**
   * A view binding associated with given activity.
   */
  private var _binding: Binding? = null

  /**
   * Allows to access a biding associated with given activity.
   */
  protected val binding: Binding
    get() = _binding ?: throw IllegalStateException(
      "Binding is not available at this moment of component lifecycle."
    )

  /**
   * Called at the end of onCreate(). Can be used to set data bindings.
   */
  abstract fun bindView(binding: Binding)

  /**
   * Holds a weak reference to the activity.
   * <p>
   * A part of activity trait interface to help trait activity-dependant
   * features.
   */
  override val activityTrait: WeakReference<Activity>
    get() = WeakReference(this)

  /**
   * Holds a weak reference to the context.
   * <p>
   * A part of context trait interface to help trait context-dependant features.
   */
  override val contextTrait: WeakReference<Context>
    get() = WeakReference(this)

  /**
   * Holds a weak reference to the activity.
   * <p>
   * A part of navigation trait interface to simplify navigation controller
   * implementation.
   */
  override val navigationTrait: WeakReference<Activity>
    get() = WeakReference(this)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    _binding =
      DataBindingUtil.setContentView(this, layoutResId)

    binding.lifecycleOwner = this

    bindView(binding)
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
    clearDisposables()
  }
}
