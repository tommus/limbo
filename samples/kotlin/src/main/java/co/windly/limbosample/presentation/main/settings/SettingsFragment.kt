package co.windly.limbosample.presentation.main.settings

import co.windly.limbo.fragment.base.LimboFragment
import co.windly.limbosample.R

class SettingsFragment : LimboFragment<SettingsView, SettingsPresenter>(), SettingsView {

  //region Fragment

  companion object {

    fun createInstance(): SettingsFragment =
        SettingsFragment()
  }

  //endregion

  //region Ui

  override fun getLayout(): Int =
      R.layout.fragment_settings

  //endregion

  //region Presenter

  // TODO: Inject presenter. Eg. using Dagger.
  override fun createPresenter(): SettingsPresenter =
      SettingsPresenter()

  //endregion
}
