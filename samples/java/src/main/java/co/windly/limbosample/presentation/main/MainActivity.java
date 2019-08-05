package co.windly.limbosample.presentation.main;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.activity.base.BaseActivity;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

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
}
