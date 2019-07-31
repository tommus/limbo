package co.windly.limbosample.presentation.main.home;

import androidx.annotation.NonNull;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;
import javax.inject.Inject;

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

  //region Presenter

  @Inject
  @SuppressWarnings("WeakerAccess")
  protected HomePresenter homePresenter;

  @NonNull
  @Override
  public HomePresenter createPresenter() {
    return homePresenter;
  }

  //endregion
}
