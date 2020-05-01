<layout
  xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto">

  <!-- region Binding -->

  <data>

    <variable
      name="disposables"
      type="io.reactivex.disposables.CompositeDisposable" />

    <variable
      name="viewModel"
      type="${packageName}.${viewModelClassName}" />

  </data>

  <!-- endregion -->

  <!-- region Root -->

  <FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- region TODO: -->

    <TextView
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"
      android:layout_gravity="center"
      android:text="TODO\n${prefix} View"
      android:textAlignment="center" />

    <!-- endregion -->

  </FrameLayout>

  <!-- endregion -->

</layout>
