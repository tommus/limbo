package ${packageName}

import androidx.lifecycle.ViewModel
import co.windly.limbo.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ${moduleClassName} {

  //region Binding

  @Binds
  @IntoMap
  @ViewModelKey(${viewModelClassName}::class)
  abstract fun bind${viewModelClassName}(viewModel: ${viewModelClassName}): ViewModel

  //endregion

  //region Contribution

  @ContributesAndroidInjector
  abstract fun contributeAndroidInjector(): ${fragmentClassName}

  //endregion
}
