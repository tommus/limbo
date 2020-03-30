package co.windly.limbosample.presentation.main.root.home

import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment

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
}
