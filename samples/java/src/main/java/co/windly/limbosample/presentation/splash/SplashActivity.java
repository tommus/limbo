package co.windly.limbosample.presentation.splash;

import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbosample.R;

public class SplashActivity extends LimboActivity<SplashView, SplashPresenter> implements SplashView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public SplashPresenter createPresenter() {
    return new SplashPresenter();
  }

  //endregion
}
