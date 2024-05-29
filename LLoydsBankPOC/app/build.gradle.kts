plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") // Kotlin Symbol Processing (KSP) plugin.
    id("dagger.hilt.android.plugin") // Dagger Hilt plugin for Android.
    id("androidx.navigation.safeargs.kotlin") // Safe Args plugin for Android Jetpack Navigation component.
    id("kotlin-kapt")
}

android {
    namespace = "com.ss.lloydsbankpoc"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ss.lloydsbankpoc"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    //implementation(platform("androidx.compose:compose-bom:2023.08.00"))
//    implementation("androidx.core:core-ktx:1.12.0") // Kotlin extensions for Android.
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2") // Kotlin extensions for lifecycle awareness.
//    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("androidx.navigation:navigation-compose:2.7.4") // Jetpack Navigation with Compose.
    implementation("com.google.accompanist:accompanist-navigation-animation:0.33.2-alpha") // Animations for Compose Navigation.
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.30.1") // System UI control
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // AndroidX ViewModel library with Kotlin extensions.
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") // Kotlin extensions for LiveData with Lifecycle.
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // ViewModel utilities for Compose.
    implementation("com.google.dagger:hilt-android:2.48.1") // Dependency injection with Dagger Hilt for Android.
    kapt("com.google.dagger:hilt-android-compiler:2.48.1") // Annotation processor for Dagger Hilt.
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0") // Hilt extension for Navigation in Compose.
    kapt("com.google.dagger:dagger-android-processor:2.48.1") // Annotation processor for Dagger Hilt.
    implementation("androidx.room:room-runtime:2.6.0") // Android Jetpack's Room persistence library.
    ksp("androidx.room:room-compiler:2.6.0") // Annotation processor for Room.
    implementation("androidx.room:room-ktx:2.6.0") // Kotlin extensions for Room.
    implementation("androidx.datastore:datastore-preferences:1.0.0") // Datastore preference
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit is a type-safe HTTP client for Android and Java.
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2") // An OkHttp interceptor which logs HTTP request and response data.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // A Retrofit 2 converter which uses Gson for serialization to and from JSON.
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.3") // An HTTP client for sending and receiving network requests.
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0") // A Retrofit 2 converter for scalars (primitives and boxed types).
    implementation("io.coil-kt:coil-compose:2.4.0") // Loading image from url


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
   // androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("org.mockito:mockito-core:2.11.0")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation("com.google.truth:truth:1.1")
// For Robolectric tests.
    testImplementation("com.google.dagger:hilt-android-testing:2.28-alpha")
// For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.28-alpha")

    kaptTest("com.google.dagger:hilt-android-compiler:2.40.5")
}