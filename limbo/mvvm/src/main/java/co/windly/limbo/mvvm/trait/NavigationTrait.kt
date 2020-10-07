package co.windly.limbo.mvvm.trait

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController

interface ActivityNavigationTrait : ActivityTrait {

  val navigationTrait: Activity

  fun navigateUp() {

    // Navigate up in a view hierarchy.
    activityTrait.onBackPressed()
  }
}

interface FragmentNavigationTrait : FragmentTrait {

  //region Trait

  val navigationTrait: Fragment

  //endregion

  //region Navigation Controller

  fun findNavController(): NavController =
    navigationTrait.findNavController()

  //endregion

  //region Resource Destination

  fun navigate(@IdRes resId: Int) =
    findNavController().navigate(resId)

  fun navigate(@IdRes resId: Int, args: Bundle?) =
    findNavController().navigate(resId, args)

  fun navigate(@IdRes resId: Int, args: Bundle?, navOptions: NavOptions?) =
    findNavController().navigate(resId, args, navOptions)

  fun navigate(
    @IdRes resId: Int, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController().navigate(resId, args, navOptions, navigatorExtras)

  //endregion

  //region Deep Link

  fun navigate(deepLink: Uri) =
    findNavController().navigate(deepLink)

  fun navigate(deepLink: Uri, navOptions: NavOptions?) =
    findNavController().navigate(deepLink, navOptions)

  fun navigate(deepLink: Uri, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController().navigate(deepLink, navOptions, navigatorExtras)

  fun navigate(request: NavDeepLinkRequest) =
    findNavController().navigate(request)

  fun navigate(request: NavDeepLinkRequest, navOptions: NavOptions?) =
    findNavController().navigate(request, navOptions)

  fun navigate(
    request: NavDeepLinkRequest, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController().navigate(request, navOptions, navigatorExtras)

  //endregion

  //region Destination

  fun navigate(directions: NavDirections) =
    findNavController().navigate(directions)

  fun navigate(directions: NavDirections, navOptions: NavOptions?) =
    findNavController().navigate(directions, navOptions)

  fun navigate(directions: NavDirections, navigatorExtras: Navigator.Extras) =
    findNavController().navigate(directions, navigatorExtras)

  //endregion

  //region Back

  fun popBackStack() =
    findNavController().popBackStack()

  fun popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false) =
    findNavController().popBackStack(destinationId, inclusive)

  fun navigateUp() =
    findNavController().navigateUp()

  //endregion
}
