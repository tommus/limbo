package co.windly.limbosample.presentation.splash;

import android.content.Intent;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.activity.base.BaseActivity;
import co.windly.limbosample.presentation.main.MainActivity;

public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Navigation

  @Override
  public void navigateToMainView() {

    // Prepare intent.
    final Intent intent = MainActivity.createIntent(this);

    // Start activity.
    startActivity(intent);
  }

  //endregion
}
