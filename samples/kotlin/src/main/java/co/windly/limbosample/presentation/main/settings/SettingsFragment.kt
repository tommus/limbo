package co.windly.limbosample.presentation.main.settings

import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment
import javax.inject.Inject

class SettingsFragment : BaseFragment<SettingsView, SettingsPresenter>(), SettingsView {

  //region Fragment

  companion object {

    fun createInstance(): SettingsFragment =
      SettingsFragment()
  }

  //endregion

  //region Ui

  override val layout: Int
    get() = R.layout.fragment_settings

  //endregion

  //region Presenter

  @Inject
  lateinit var settingsPresenter: SettingsPresenter

  override fun createPresenter(): SettingsPresenter =
    settingsPresenter

  //endregion
}
