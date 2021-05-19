package co.windly.limbo.mvvm.trait

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

interface ActivityTrait {

  /**
   * Holds a weak reference to the activity.
   * <p>
   * A part of activity trait interface to help trait activity-dependant
   * features.
   */
  val activityTrait: WeakReference<Activity>
}

interface ContextTrait {

  /**
   * Holds a weak reference to the context.
   * <p>
   * A part of context trait interface to help trait context-dependant features.
   */
  val contextTrait: WeakReference<Context>
}

interface FragmentTrait {

  /**
   * Holds a weak reference to the fragment.
   * <p>
   * A part of fragment trait interface to help trait activity-dependant
   * features.
   */
  val fragmentTrait: WeakReference<Fragment>
}
