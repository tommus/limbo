package co.windly.limbosample.presentation.main.home;

import androidx.annotation.NonNull;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;
import javax.inject.Inject;

public class HomeFragment extends BaseFragment<HomeView, HomePresenter> implements HomeView {

  //region Fragment

  @Inject
  @SuppressWarnings("WeakerAccess")
  protected HomePresenter homePresenter;

  //endregion

  //region Ui

  public static HomeFragment createInstance() {
    return new HomeFragment();
  }

  //endregion

  //region Presenter

  @Override
  protected int getLayout() {
    return R.layout.fragment_home;
  }

  @NonNull
  @Override
  public HomePresenter createPresenter() {
    return homePresenter;
  }

  //endregion
}
