package co.windly.limbosample.presentation.main.home;

import android.support.annotation.NonNull;
import co.windly.limbo.fragment.base.LimboFragment;
import co.windly.limbosample.R;

public class HomeFragment extends LimboFragment<HomeView, HomePresenter> implements HomeView {

  //region Fragment

  public static HomeFragment createInstance() {
    return new HomeFragment();
  }

  //endregion

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.fragment_home;
  }

  //endregion

  //region Presenter

  @NonNull
  @Override
  public HomePresenter createPresenter() {
    return new HomePresenter();
  }

  //endregion
}
