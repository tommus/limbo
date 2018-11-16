package co.windly.limbosample.presentation.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import co.windly.limbo.activity.fragment.LimboFragmentActivity;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.main.home.HomeFragment;

public class MainActivity extends LimboFragmentActivity<MainView, MainPresenter> implements MainView {

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

  //region Lifecycle

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Load fragment.
    loadHomeFragment();
  }

  //endregion

  //region Fragment

  private void loadHomeFragment() {

    // Check whether fragment is already added.
    final LimboFragment fragment = findFragment(HomeFragment.class);

    // In case if not added - load.
    if (fragment == null) {
      loadRootFragment(R.id.fragmentContainer, HomeFragment.createInstance());
    }
  }

  //endregion
}
