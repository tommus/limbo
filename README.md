# Limbo
[![Maven Central][mavenbadge-svg]][mavencentral] [![Travis (.org) branch][travisci-svg]][travisci] [![API][apibadge-svg]][apioverview] [![GitHub][license-svg]][license]

A collection of libraries that empowers Android development using one of two
architectural patterns:

- Model-View-ViewModel - with no additional dependencies.

It is strongly recommended to design the application using single activity,
but it's not required.

### Usage

### Add dependencies

```groovy
dependencies {
    implementation "co.windly:limbo-mvvm:5.0.0-SNAPSHOT"
}
```

For Model-View-ViewModel application (with Dagger), use the following dependencies:

```groovy
dependencies {
    implementation "co.windly:limbo-mvvm:5.0.0-SNAPSHOT"
    implementation "co.windly:limbo-mvvm-dagger:5.0.0-SNAPSHOT"
}
```

Optionally, you can add one of utility packages:

```groovy
dependencies {
    implementation "co.windly:limbo-disposable:5.0.0-SNAPSHOT"
    implementation "co.windly:limbo-recyclerview:5.0.0-SNAPSHOT"
    implementation "co.windly:limbo-utility:5.0.0-SNAPSHOT"
}
```

## License

    Copyright 2021 Tomasz Dzieniak, Adrian Zalewski

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[apibadge-svg]: https://img.shields.io/badge/API-19%2B-brightgreen.svg?color=97ca00
[apioverview]: https://developer.android.com/about/versions/android-4.4
[license-svg]: https://img.shields.io/github/license/tommus/limbo.svg?color=97ca00
[license]: http://www.apache.org/licenses/LICENSE-2.0
[mavenbadge-svg]: https://img.shields.io/maven-central/v/co.windly/limbo-mvvm.svg?color=97ca00
[mavencentral]: https://search.maven.org/artifact/co.windly/limbo-mvvm
[travisci-svg]: https://img.shields.io/travis/tommus/limbo/master.svg?color=97ca00
[travisci]: https://travis-ci.org/tommus/limbo-mvvm
