package co.windly.limbosample.presentation.main

import android.content.Context
import android.content.Intent
import co.windly.limbosample.R
import co.windly.limbosample.presentation.base.activity.base.BaseActivity

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

  //region Activity

  companion object {

    fun createIntent(context: Context): Intent =
      Intent(context, MainActivity::class.java)
  }

  //endregion

  //region Ui

  override val layout: Int
    get() = R.layout.activity_main

  //endregion
}
