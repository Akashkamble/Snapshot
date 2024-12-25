import org.gradle.internal.classpath.Instrumented.systemProperty

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.screenshot)
    id("com.google.devtools.ksp")
    alias(libs.plugins.kotlin.compose)
}
val snapshotFileGenerationPath: String by project

android {
    namespace = "dev.akash42.snapshotcodegenerator"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.akash42.snapshotcodegenerator"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField("String", "FILE_PATH", "\"/Users/akashkamble/AndroidStudioProjects/SnapshotCodeGenerator/app/src/screenshotTest/kotlin\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ksp {
        arg("snapshotFileGenerationPath", "/Users/akashkamble/AndroidStudioProjects/SnapshotCodeGenerator/app/src/screenshotTest/kotlin")
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    screenshotTestImplementation(libs.androidx.ui.tooling)
    implementation(kotlin("stdlib"))
    implementation(project(":snapshotannotation"))
    ksp(project(":snapshotprocessor"))
    implementation(project(":snapshotprocessor"))
}

tasks.named("build") {
    doFirst {
        System.setProperty("MY_STRING", "Some String")
    }
}

tasks.register("checkSystemProperty") {
    doLast {
        println("MY_STRING: ${System.getProperty("MY_STRING")}")
    }
}