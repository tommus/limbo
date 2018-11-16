package co.windly.limbosample.presentation.main.home

import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbosample.R

class HomeFragment : LimboFragment<HomeView, HomePresenter>(), HomeView {

  //region Fragment

  companion object {

    fun createInstance() = HomeFragment()
  }

  //endregion

  //region Ui

  override fun getLayout() = R.layout.fragment_home

  //endregion

  //region Presenter

  override fun createPresenter() = HomePresenter()

  //endregion
}
