package co.windly.limbo.fragment.dialog

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import co.windly.limbo.LimboPresenter
import co.windly.limbo.disposable.LifecycleCompositeDisposable
import co.windly.limbo.disposable.lifecycleDestroyCompositeDisposable
import co.windly.limbo.fragment.base.LimboFragmentView
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback
import io.reactivex.disposables.Disposable

abstract class LimboDialogFragment<V : LimboFragmentView, P : LimboPresenter<V>> :
  DialogFragment(), MvpDelegateCallback<V, P>, LimboFragmentView {

  //region Reactive

  override val disposables: LifecycleCompositeDisposable
    by lifecycleDestroyCompositeDisposable()

  override fun addDisposable(disposable: Disposable): Boolean =
    disposables.add(disposable)

  override fun clearDisposables() {
    disposables.clear()
  }

  //endregion

  //region Delegate

  val mvpDelegate: FragmentMvpDelegate<V, P>
    by lazy {
      FragmentMvpDelegateImpl(this, this, true, true)
    }

  //endregion

  //region Ui

  @get:LayoutRes
  protected abstract val layout: Int

  //endregion

  //region Presenter

  protected var mvpPresenter: P? =
    null

  override fun getPresenter(): P =
    requireNotNull(mvpPresenter)

  override fun setPresenter(presenter: P) {
    mvpPresenter = presenter
  }

  abstract override fun createPresenter(): P

  //endregion

  //region View

  override fun getMvpView(): V =
    this as V

  //endregion

  //region Lifecycle

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?): View? =
    inflater.inflate(layout, container, false)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mvpDelegate.onViewCreated(view, savedInstanceState)
  }

  override fun onDestroyView() {
    mvpDelegate.onDestroyView()
    super.onDestroyView()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mvpDelegate.onCreate(savedInstanceState)
  }

  override fun onDestroy() {

    // Clear presenter-bound disposables.
    presenter.clearDisposables()

    // Inform delegate that fragment is being destroy'ed.
    mvpDelegate.onDestroy()

    // Continue destroy'ing fragment.
    super.onDestroy()
  }

  override fun onPause() {
    super.onPause()
    mvpDelegate.onPause()
  }

  override fun onResume() {
    super.onResume()
    mvpDelegate.onResume()
  }

  override fun onStart() {
    super.onStart()
    mvpDelegate.onStart()
  }

  override fun onStop() {
    super.onStop()
    mvpDelegate.onStop()
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    mvpDelegate.onActivityCreated(savedInstanceState)
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    mvpDelegate.onAttach(context as Activity?)
  }

  override fun onAttach(activity: Activity) {
    super.onAttach(activity)
    mvpDelegate.onAttach(activity)
  }

  override fun onDetach() {
    mvpDelegate.onDetach()
    super.onDetach()
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    mvpDelegate.onSaveInstanceState(outState)
  }

  //endregion
}
