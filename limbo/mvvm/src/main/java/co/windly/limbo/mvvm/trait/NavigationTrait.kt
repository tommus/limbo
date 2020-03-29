package co.windly.limbo.mvvm.trait

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

interface ActivityNavigationTrait : ActivityTrait {

  val navigationTrait: Activity

  fun navigateUp() {

    // Navigate up in a view hierarchy.
    activityTrait.onBackPressed()
  }
}

interface FragmentNavigationTrait : FragmentTrait {

  val navigationTrait: Fragment

  fun navigateUp() {

    // Pop current fragment.
    navigationTrait
      .findNavController()
      .navigateUp()
  }
}
