package co.windly.limbosample.presentation.splash

import android.Manifest
import android.content.Intent
import android.os.Bundle
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbosample.R
import co.windly.limbosample.service.ViewBoundService
import kotlinx.android.synthetic.main.activity_splash.startServiceButtonView
import kotlinx.android.synthetic.main.activity_splash.stopServiceButtonView
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class SplashActivity : LimboActivity<SplashView, SplashPresenter>(), SplashView {

  //region Ui

  override val layout: Int
    get() = R.layout.activity_splash

  //endregion

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Attach start service button listener.
    startServiceButtonView
      .setOnClickListener { getPresenter().onStartServiceButtonClicked() }

    // Attach stop service button listener.
    stopServiceButtonView
      .setOnClickListener { getPresenter().onStopServiceButtonClicked() }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)

    // Pass data to permission dispatcher.
    onActivityResult(requestCode)
  }

  //endregion

  //region Presenter

  // TODO: Inject presenter. Eg. using Dagger.
  override fun createPresenter(): SplashPresenter =
    SplashPresenter()

  //endregion

  //region Service

  @NeedsPermission(value = [Manifest.permission.SYSTEM_ALERT_WINDOW])
  internal fun startViewBoundServiceProxy() {

    // Start view bound service.
    startService(Intent(this, ViewBoundService::class.java))
  }

  override fun startViewBoundService() {

    // Start view bound service.
    startViewBoundServiceProxyWithPermissionCheck()
  }

  override fun stopViewBoundService() {

    // Stop view bound service.
    stopService(Intent(this, ViewBoundService::class.java))
  }

  //endregion
}
