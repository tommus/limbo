package co.windly.limbo.mvvm.trait

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import java.lang.ref.WeakReference

interface ActivityNavigationTrait : ActivityTrait {

  /**
   * Holds a weak reference to the activity.
   * <p>
   * A part of navigation trait interface to simplify navigation controller
   * implementation.
   */
  val navigationTrait: WeakReference<Activity>

  /**
   * Navigate up in a view hierarchy.
   */
  fun navigateUp() {
    activityTrait.get()?.onBackPressed()
  }
}

interface FragmentNavigationTrait : FragmentTrait {

  /**
   * Holds a weak reference to the fragment.
   * <p>
   * A part of navigation trait interface to simplify navigation controller
   * implementation.
   */
  val navigationTrait: WeakReference<Fragment>

  fun findNavController(): NavController? =
    navigationTrait.get()?.findNavController()

  fun navigate(@IdRes resId: Int) =
    findNavController()?.navigate(resId)

  fun navigate(@IdRes resId: Int, args: Bundle?) =
    findNavController()?.navigate(resId, args)

  fun navigate(@IdRes resId: Int, args: Bundle?, navOptions: NavOptions?) =
    findNavController()?.navigate(resId, args, navOptions)

  fun navigate(
    @IdRes resId: Int, args: Bundle?, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController()?.navigate(resId, args, navOptions, navigatorExtras)

  fun navigate(deepLink: Uri) =
    findNavController()?.navigate(deepLink)

  fun navigate(deepLink: Uri, navOptions: NavOptions?) =
    findNavController()?.navigate(deepLink, navOptions)

  fun navigate(deepLink: Uri, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController()?.navigate(deepLink, navOptions, navigatorExtras)

  fun navigate(request: NavDeepLinkRequest) =
    findNavController()?.navigate(request)

  fun navigate(request: NavDeepLinkRequest, navOptions: NavOptions?) =
    findNavController()?.navigate(request, navOptions)

  fun navigate(
    request: NavDeepLinkRequest, navOptions: NavOptions?, navigatorExtras: Navigator.Extras?) =
    findNavController()?.navigate(request, navOptions, navigatorExtras)

  fun navigate(directions: NavDirections) =
    findNavController()?.navigate(directions)

  fun navigate(directions: NavDirections, navOptions: NavOptions?) =
    findNavController()?.navigate(directions, navOptions)

  fun navigate(directions: NavDirections, navigatorExtras: Navigator.Extras) =
    findNavController()?.navigate(directions, navigatorExtras)

  fun popBackStack() =
    findNavController()?.popBackStack()

  fun popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false) =
    findNavController()?.popBackStack(destinationId, inclusive)

  fun navigateUp() =
    findNavController()?.navigateUp()

  /**
   * Observes a result delivered by target destination of this destination
   * (fragment or dialog fragment).
   */
  fun <Result : Parcelable> FragmentNavigationTrait.observeResult(
    key: String,
    onResult: (Result) -> Unit
  ) {

    // Access current back stack entry.
    val entry = findNavController()?.currentBackStackEntry

    // Register observer aware of event's lifecycle.
    val observer = LifecycleEventObserver { _, event ->

      // Care only for resumed events.
      if (event == ON_RESUME) {

        // Retrieve result.
        val result =
          entry
            ?.savedStateHandle
            ?.remove<Result>(key)
            ?: return@LifecycleEventObserver

        // Process result.
        onResult.invoke(result)
      }
    }

    // Add event observer.
    entry?.lifecycle?.addObserver(observer)

    // Register observer keeping track of view's lifecycle.
    fragmentTrait.get()?.viewLifecycleOwner?.lifecycle
      ?.addObserver(LifecycleEventObserver { _, event ->

        // Remove observer when view destroyed.
        if (event == Lifecycle.Event.ON_DESTROY) {
          entry?.lifecycle?.removeObserver(observer)
        }
      })
  }

  /**
   * Sets a result that will be delivered to the previous destination
   * (fragment or dialog fragment).
   */
  fun <Result : Parcelable> setResult(key: String, result: Result) {

    // Access previous back stack entry.
    val entry = findNavController()?.previousBackStackEntry

    // Set the result.
    entry?.savedStateHandle?.set(key, result)
  }
}
