package co.windly.limbosample.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.main.MainActivity;

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

  //region Navigation

  @Override
  public void navigateToMainView() {

    // Prepare intent.
    final Intent intent = MainActivity.createIntent(this);

    // Start activity.
    startActivity(intent);
  }

  //endregion

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Start counting the automatic timer.
    getPresenter().observeAutomaticContinue();
  }

  //endregion
}
