package co.windly.limbosample.presentation.main.home

import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeView, HomePresenter>(), HomeView {

  //region Fragment

  companion object {

    fun createInstance(): HomeFragment =
      HomeFragment()
  }

  //endregion

  //region Ui


  override val layout: Int
    get() = R.layout.fragment_home

  //endregion

  //region Presenter

  @Inject
  lateinit var homePresenter: HomePresenter

  override fun createPresenter(): HomePresenter =
    homePresenter

  //endregion
}
