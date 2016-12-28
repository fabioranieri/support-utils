# Support Utils

Install
========

Add our maven repository in your gradle

```Gradle
repositories {
    maven {
        url 'http://dl.bintray.com/dev-fingerlinks/maven'
    }
}
```

And add the compile

```Gradle
dependencies {
    compile 'org.fingerlinks.mobile.android:support-base:25.0.1.1'
    compile 'org.fingerlinks.mobile.android:support-ui:25.0.1.1'
    compile 'org.fingerlinks.mobile.android:support-recyclerview:25.0.1.1'
    compile 'org.fingerlinks.mobile.android:support-widget:25.0.1.1'
}
```
How to read version code... 25.0.1.1
- 25.0.1 support libs version
- 1 support utils version for current support libs
