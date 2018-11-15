package co.windly.limbosample.presentation.main

import android.content.Context
import android.content.Intent
import co.windly.limbo.activity.base.LimboActivity
import co.windly.limbosample.R

class MainActivity : LimboActivity<MainView, MainPresenter>(), MainView {

  //region Activity

  companion object {

    fun createIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
  }

  //endregion

  //region Ui

  override fun getLayout() = R.layout.activity_main

  //endregion

  //region Presenter

  override fun createPresenter() = MainPresenter()

  //endregion
}
