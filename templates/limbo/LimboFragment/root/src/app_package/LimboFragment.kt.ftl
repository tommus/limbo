package ${packageName}

class ${fragmentClassName} : BaseFragment<Fragment${prefix}Binding, ${viewModelClassName}>(), ${traitClassName} {

  //region Ui

  override val layoutRes: Int
    get() = R.layout.${escapeXmlAttribute(fragmentName)}

  //endregion

  //region View Model

  override val viewModel: ${viewModelClassName}
    by viewModels { factory }

  //endregion

  //region Binding

  override fun bindView(binding: Fragment${prefix}Binding) {
    binding
      .also { it.disposables = disposables }
      .also { it.viewModel = viewModel }
  }

  //endregion
}
