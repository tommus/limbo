package co.windly.limbosample.presentation.main.root;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import co.windly.limbosample.R;
import co.windly.limbosample.presentation.base.fragment.base.BaseFragment;
import co.windly.limbosample.presentation.main.root.home.HomeFragment;
import co.windly.limbosample.presentation.main.root.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RootFragment extends BaseFragment<RootView, RootPresenter> implements RootView {

  //region Ui

  @Override
  protected int getLayout() {
    return R.layout.fragment_root;
  }

  //endregion

  //region Navigation

  @Override
  public void navigateToHomeView() {

    // Create new fragment.
    final BaseFragment fragment = HomeFragment.createInstance();

    // Replace fragment.
    replaceBottomFragment(fragment);
  }

  @Override
  public void navigateToSettingsView() {

    // Create new fragment.
    final BaseFragment fragment = SettingsFragment.createInstance();

    // Replace fragment.
    replaceBottomFragment(fragment);
  }

  //endregion

  //region Lifecycle

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Initialize bottom navigation.
    initializeBottomNavigation();
  }

  //endregion

  //region Bottom Navigation

  @BindView(R.id.bottomNavigation)
  BottomNavigationView bottomNavigationView;

  private void initializeBottomNavigation() {

    // Configure listener.
    bottomNavigationView.setOnNavigationItemSelectedListener(item -> {

      // Retrieve item id.
      final int itemId = item.getItemId();

      // Navigate to selected item.
      switch (itemId) {
        case R.id.action_home:
          navigateToHomeView();
          break;
        case R.id.action_settings:
          navigateToSettingsView();
          break;
      }

      return true;
    });

    // Set default selected item.
    bottomNavigationView.setSelectedItemId(R.id.action_home);
  }

  private void replaceBottomFragment(BaseFragment fragment) {

    // Start transaction.
    final FragmentTransaction transaction = requireFragmentManager().beginTransaction();

    // Put new fragment into it's container.
    transaction.replace(R.id.fragmentContainer, fragment);

    // Do not add fragment into back-stack.
    transaction.addToBackStack(null);

    // Perform transaction.
    transaction.commit();
  }

  //endregion
}
