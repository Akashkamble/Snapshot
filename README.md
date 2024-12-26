# Snapshot :camera:

This library generates the code for your compose preview screenshot tests.

## Set Up

1. You'll have to do set up for [compose preview screenshot test](https://developer.android.com/studio/preview/compose-screenshot-testing#setup) if this is not already done.


2. in your root level build.gradle file add Jitpack url like below.

```gradle
dependencyResolutionManagement {
    
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

3. Add KSP plugin classpath in your root level build.gradle file and Kotlin JVM Plugin in your plugins
```gradle
buildscript {
    dependencies {
        ...
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.1.0-1.0.29")
    }
}

plugins {
    ...
    id "org.jetbrains.kotlin.jvm" version "2.1.0" apply false
}

```

4. In your module level build.gradle file you have to add KSP plugin and KSP options
```gradle
plugins {
    ....
    id 'com.google.devtools.ksp'
}

android {
...
  ksp {
        arg("snapshotFileGenerationPath", "<Local directory path to screenshotTest source set>")
    }
}
```
  [Checkout this file](https://github.com/Akashkamble/Snapshot/blob/main/app/build.gradle.kts) on how to set the directory path.

5. finally implement the library in your module.
```gradle
dependencies {
    ...
    implementation 'com.github.Akashkamble.Snapshot:snapshotannotation:<latest-version>'
    ksp("com.github.Akashkamble.Snapshot:snapshotprocessor:<latest-version>")
}
```

Now you're ready to use the library.

## How to use this library?

Wherever you have your compose previews just add @Snapshot annotation on it with file name and composable name which you're trying to preview.
Example
```kotlin
@Snapshot(fileName = "Preview.kt", composableName = "Greeting")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SnapshotCodeGeneratorTheme {
        Greeting("Android") // this exact name should be given as composableName in the annotation.
    }
}
```

After rebuilding the project in your screenshotTest source set you will see your @Preview code with file name as Preview.kt

Now you just have to use

[This command to generate reference Images](https://developer.android.com/studio/preview/compose-screenshot-testing#generate-reference-images)

[This to generate the report](https://developer.android.com/studio/preview/compose-screenshot-testing#generate-test-report)



