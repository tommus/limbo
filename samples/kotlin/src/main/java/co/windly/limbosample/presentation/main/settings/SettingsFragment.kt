package co.windly.limbosample.presentation.main.settings

import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbosample.R

class SettingsFragment : LimboFragment<SettingsView, SettingsPresenter>(), SettingsView {

  //region Fragment

  companion object {

    fun createInstance() = SettingsFragment()
  }

  //endregion

  //region Ui

  override fun getLayout() = R.layout.fragment_settings

  //endregion

  //region Presenter

  override fun createPresenter() = SettingsPresenter()

  //endregion
}
