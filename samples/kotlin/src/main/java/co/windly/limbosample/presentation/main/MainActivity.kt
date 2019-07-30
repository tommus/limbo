package co.windly.limbosample.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.activity.fragment.BaseFragmentActivity
import co.windly.limbosample.presentation.main.home.HomeFragment
import co.windly.limbosample.presentation.main.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.bottomNavigation
import javax.inject.Inject

class MainActivity : BaseFragmentActivity<MainView, MainPresenter>(), MainView {

  //region Activity

  companion object {

    fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
  }

  //endregion

  //region Ui

  override val layout: Int
    get() = R.layout.activity_main

  //endregion

  //region Presenter

  @Inject
  lateinit var mainPresenter: MainPresenter

  override fun createPresenter(): MainPresenter =
    mainPresenter

  //endregion

  //region Navigation

  private fun initializeBottomNavigation() {

    // Configure listener.
    bottomNavigation.setOnNavigationItemSelectedListener {

      // Navigate to selected item.
      when (it.itemId) {
        R.id.action_home -> navigateToHomeView()
        R.id.action_settings -> navigateToSettingsView()
      }

      true
    }
  }

  override fun navigateToHomeView() {

    // Prepare fragment.
    val fragment = HomeFragment.createInstance()

    // Replace current fragment.
    supportDelegate
      .replaceFragment(fragment, false)
  }

  override fun navigateToSettingsView() {

    // Prepare fragment.
    val fragment = SettingsFragment.createInstance()

    // Replace current fragment.
    supportDelegate
      .replaceFragment(fragment, false)
  }

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Initialize bottom navigation.
    initializeBottomNavigation()

    // Load fragment.
    loadHomeFragment()
  }

  //endregion

  //region Fragment

  private fun loadHomeFragment() {

    // Check whether fragment is already added.
    val fragment = findFragment(HomeFragment::class.java)

    // In case if not added - load.
    if (fragment == null) {
      loadRootFragment(R.id.fragmentContainer, HomeFragment.createInstance())
    }
  }

  //endregion
}
