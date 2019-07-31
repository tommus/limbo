package co.windly.limbosample.presentation.splash;

import android.content.Intent;
import androidx.annotation.NonNull;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.activity.base.BaseActivity;
import co.windly.limbosample.presentation.main.MainActivity;
import javax.inject.Inject;

public class SplashActivity extends BaseActivity<SplashView, SplashPresenter> implements SplashView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_splash;
  }

  //endregion

  //region Presenter

  @Inject
  protected SplashPresenter splashPresenter;

  @NonNull
  @Override
  public SplashPresenter createPresenter() {
    return splashPresenter;
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
