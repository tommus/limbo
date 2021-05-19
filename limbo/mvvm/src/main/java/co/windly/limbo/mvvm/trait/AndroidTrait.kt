package co.windly.limbo.mvvm.trait

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

interface ActivityTrait {

  val activityTrait: WeakReference<Activity>
}

interface ContextTrait {

  val contextTrait: WeakReference<Context>
}

interface FragmentTrait {

  val fragmentTrait: WeakReference<Fragment>
}
