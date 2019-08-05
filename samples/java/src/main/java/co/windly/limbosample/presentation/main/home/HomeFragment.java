package co.windly.limbosample.presentation.main.home;

import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;

public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

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
}
