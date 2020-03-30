package co.windly.limbosample.presentation.main.root

import android.os.Bundle
import android.view.View
import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment
import co.windly.limbosample.presentation.main.root.home.HomeFragment
import co.windly.limbosample.presentation.main.root.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_root.bottomNavigation

class RootFragment : BaseFragment<RootView, RootPresenter>(), RootView {

  //region Ui

  override val layout: Int
    get() = R.layout.fragment_root

  //endregion

  //region Navigation

  override fun navigateToHomeView() {

    // Create new fragment.
    val fragment = HomeFragment.createInstance()

    // Replace fragment.
    replaceBottomFragment(fragment)
  }

  override fun navigateToSettingsView() {

    // Create new fragment.
    val fragment = SettingsFragment.createInstance()

    // Replace fragment.
    replaceBottomFragment(fragment)
  }

  //endregion

  //region Lifecycle

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    // Initialize bottom navigation.
    initializeBottomNavigation()
  }

  //endregion

  //region Bottom Navigation

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

    // Set default selected item.
    bottomNavigation.selectedItemId = R.id.action_home
  }

  private fun replaceBottomFragment(fragment: BaseFragment<*, *>) {

    // Start transaction.
    val transaction = requireFragmentManager().beginTransaction()

    // Put new fragment into it's container.
    transaction.replace(R.id.fragmentContainer, fragment)

    // Do not add fragment into back-stack.
    transaction.addToBackStack(null)

    // Perform transaction.
    transaction.commit()
  }

  //endregion
}
