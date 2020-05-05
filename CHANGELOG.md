### Change Log

### Version 3.0.1 *(2020-05-05)*

  * Added `MvvmDialogFragment` and `DaggerMvvmDialogFragment`;
  * Update Android Gradle Plugin (3.6.3);
  * Update AndroidX Navigation (2.2.2);
  * Update Kotlin JDK8 (1.3.72);

### Version 3.0.0 *(2020-03-30)*

  * Added `limbo-mvvm-dagger` module.

### Version 2.4.0 *(2020-03-29)*

  * Added `limbo-mvvm` module;
  * Old `limbo` module moved to `limbo-mvp`;
  * Assigned new package name for `limbo-mvp`; 
  * Update Android Gradle Plugin (3.6.1);
  * Update AndroidX Code (1.2.0);
  * Update AndroidX Fragment (1.2.3);
  * Update AndroidX Lifecycle (2.2.0);
  * Update AndroidX Navigation (2.2.1);
  * Update ButterKnife (10.2.1);
  * Update Dagger (2.27);
  * Update Kotlin JDK8 (1.3.71);
  * Update Permission dispatcher (4.7.0);
  * Update RxJava (2.2.19);
  * Update Gradle Wrapper (6.3).

### Version 2.3.2 *(2020-03-05)*

  * Add unknown exception definition.

### Version 2.3.1 *(2020-03-05)*

  * Add HttpCode definition;
  * Add commonly used network-related exceptions.

### Version 2.3.0 *(2019-12-17)*

  * Revert disposable to be implemented as composite disposable for backward compatibility.

### Version 2.2.0 *(2019-12-13)*

  * Update Kotlin JDK8 (1.3.61);
  * Update RxBinding (3.0.0);
  * Update RxJava (2.2.15);
  * Update RecyclerView (1.1.0);
  * Add extension method that allows to add disposable to disposable container;
  * Add mixin interface definitions for MapStruct;
  * Update Gradle Wrapper (6.0.1).

### Version 2.1.0 *(2019-11-29)*

  * Update lifecycle owners to use lifecycle composite disposable from (limbo-disposable);
  * New library added;
  * Remove view-bound service sample.

### Version 2.0.2 *(2019-11-19)*

  * Add more popular dimen resources including video resolutions;
  * Downgrade minimum SDK requirement.

### Version 2.0.1 *(2019-11-15)*

  * Add common RecyclerView item decorations. 

### Version 2.0.0 *(2019-11-09)*

  * Drop Fragmentation in favor of Android Navigation Component;
  * Update Gradle Wrapper (6.0);
  * Update Android Gradle Plugin (3.5.2);
  * Update AndroidX App Compat (1.1.0);
  * Update AndroidX Core (1.1.0);
  * Update AndroidX Fragment (1.1.0);
  * Update AndroidX Navigation (2.1.0);
  * Update Butter Knife (10.2.0) for Java sample;
  * Update Dagger (2.25.2);
  * Update Permissions Dispatcher (4.6.0);
  * Update RxJava (2.2.14).

### Version 1.4.2 *(2019-07-30)*

  * Add common colors and dimens to limbo-utility.

### Version 1.4.1 *(2019-07-30)*

  * Update Kotlin JDK8 (1.3.41);
  * Update Gradle Wrapper (5.5.1);
  * Update Android Gradle Plugin (3.4.2);
  * Update Dagger (2.2.4);
  * Reimplement dependency injection in samples to no longer use deprecated builders;
  * Update Fragmentation (1.0.1);
  * Update Permissions Dispatcher (4.5.0);
  * Update RxBinding (3.0.0);
  * Update RxJava (2.2.10).

### Version 1.4.0 *(2019-06-13)*

  * Switch Fragmentation (1.3.7) to FragmentationX (1.0.0) which fully supports AndroidX.

### Version 1.3.1 *(2019-06-13)*

  * Update Fragmentation (1.3.7).

### Version 1.3.0 *(2019-06-13)*

  * Correct onAttach() context nullability in LimboLceFragment.

### Version 1.2.0 *(2019-06-13)*

  * Correct onAttach() context nullability in LimboLceFragment.

### Version 1.1.4 *(2019-06-01)*

  * Correct onAttach() context nullability in LimboDialogFragment.

### Version 1.1.3 *(2019-06-01)*

  * Correct onAttach() context nullability in LimboFragment.

### Version 1.1.2 *(2019-04-29)*

  * Update Kotlin JDK8 (1.3.31);

### Version 1.1.1 *(2019-04-19)*

  * Update Kotlin JDK8 (1.3.30);
  * Update Gradle Wrapper (5.4).

### Version 1.1.0 *(2019-04-06)*

  * Implement base classes for view-bound MVP service;
  * Add view-bound service sample usage;
  * Update Gradle Wrapper (5.3.1);
  * Update samples;
  * Use Dagger for samples dependency injection.

### Version 1.0.0 *(2019-03-30)*

  * Reorganize packages;
  * Add queueing type of presenter;
  * Rename base presenter as iffy;
  * Drop useless classes;
  * Implement LCE pattern implementation for activities;
  * Update RxJava (2.2.8);
  * Update samples.

### Version 0.9.1 *(2019-03-25)*

  * Make `LimboLceFragmentPresenter` an abstract class.

### Version 0.9.0 *(2019-03-23)*

  * Update Android Gradle Plugin (3.3.2);
  * Update Gradle Wrapper (5.3).

### Version 0.8.5 *(2019-03-07)*

  * Add view-bound composite disposables.

### Version 0.8.3 *(2019-02-22)*

  * Update Android Gradle Plugin (3.3.1);
  * Update AndroidX App Compat (1.0.2);
  * Update Butter Knife (10.1.0) for Java sample;
  * Update Kotlin JDK8 (1.3.21);
  * Update RxKotlin (2.1.1).

### Version 0.8.2 *(2019-02-01)*

  * Allow method `findFragment()` in `LimboFragment` to return nullable value. 

### Version 0.8.0 *(2019-02-01)*

  * Open limbo dialog fragment presenter.

### Version 0.8.1 *(2019-02-01)*

  * Correct limbo fragment presenter property methods.

### Version 0.7.0 *(2019-02-01)*

  * Reimplement library to Kotlin.

### Version 0.6.0 *(2019-01-26)*

  * Update Android Gradle Plugin (3.3.0);
  * Update Butter Knife (10.0.0) for Java sample;
  * Update RxJava (2.2.6);
  * Remove direct dependency from Butter Knife;
  * Remove 'initializeView()' method from base classes;
  * Improve AndroidX compatibility.

### Version 0.5.7 *(2018-12-17)*

  * Update Kotlin (1.3.11) for Kotlin sample;
  * Update Mosby (3.1.1);
  * Update RxJava (2.2.4);
  * Update RxKotlin (2.3.0).

### Version 0.5.6 *(2018-11-22)*

  * First (unstable) version that supports AndroidX.

### Version 0.5.5 *(2018-11-09)*

  * Initial Maven Central release;
  * Update RxJava (2.2.3).
