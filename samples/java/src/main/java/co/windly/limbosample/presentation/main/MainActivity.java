package co.windly.limbosample.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import co.windly.limbo.activity.base.LimboActivity;
import co.windly.limbosample.R;

public class MainActivity extends LimboActivity<MainView, MainPresenter> implements MainView {

  //region Intent

  public static Intent createIntent(@NonNull Context context) {
    return new Intent(context, MainActivity.class);
  }

  //endregion

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.activity_main;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public MainPresenter createPresenter() {
    return new MainPresenter();
  }

  //endregion
}
