package co.windly.limbosample.presentation.main.home

import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbosample.R

class HomeFragment : LimboFragment<HomeView, HomePresenter>(), HomeView {

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

  // TODO: Inject presenter. Eg. using Dagger.
  override fun createPresenter(): HomePresenter =
    HomePresenter()

  //endregion
}
