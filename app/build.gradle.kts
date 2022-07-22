plugins {
    id("com.android.application")

    kotlin("android")

    //Kapt
    kotlin("kapt")

    //hilt
    id("dagger.hilt.android.plugin")

    // Navigation SafeArgs
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.peopleinfapp"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //Core
    implementation("androidx.core:core-ktx:1.8.0")

    //AppCompat
    implementation("androidx.appcompat:appcompat:1.4.2")

    //Material Design Components
    implementation("com.google.android.material:material:1.6.1")

    //UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Activity
    val activity_version = "1.4.0"

    implementation("androidx.activity:activity-ktx:$activity_version")

    // fragment
    val fragment_version = "1.4.1"

    implementation("androidx.fragment:fragment-ktx:$fragment_version")

    //viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")

    //navigation
    val nav_version = "2.3.5"
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //retrofit
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

    //okhttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.2"))
    implementation("com.squareup.okhttp3:okhttp")
    implementation("com.squareup.okhttp3:logging-interceptor")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.41")
    kapt("com.google.dagger:hilt-android-compiler:2.40")

    // Lifecycle
    val lifecycle_version = "2.4.0"

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // | for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

}