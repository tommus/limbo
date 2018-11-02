# Limbo

Composition of libraries and base classes that supports creating MVP and fragment-based Android
applications.

### Installation

1. Add Jitpack repostiory to the project `build.gradle`:

```groovy
repositories {
    /* (...) */
    maven { url "https://jitpack.io" }
}
```

2. Make sure that you have the `$limbo_version` defined in your gradle file at the project level:

```groovy
ext.limbo_version = "0.5.3"
```

3. Add dependencies:

```groovy
dependencies {
    /* (...) */
    implementation "com.github.tommus:limbo:0.5.3"
}
```

### Build

```sh
./gradlew clean assemble
```
