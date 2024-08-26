
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("dagger.hilt.android.plugin")
    kotlin("kapt")





}



android {
    namespace = "com.example.githubusersearch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.githubusersearch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"

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

    dependencies {
        // Core AndroidX libraries
        implementation(libs.androidx.core.ktx) // Kotlin extensions for Android
        implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle-aware components
        implementation(libs.androidx.activity.compose) // Compose support for activities

        implementation (libs.androidx.runtime.livedata.v100beta01)

        //Compose
        implementation(platform(libs.androidx.compose.bom)) // Compose Bill of Materials (BOM) for consistent versions
        implementation(libs.androidx.ui) // Core UI components for Compose
        implementation(libs.androidx.ui.graphics) // Graphics support for Compose
        implementation(libs.androidx.ui.tooling.preview) // Tooling support for Compose previews
        implementation(libs.androidx.material) // Material Design components for Compose
        implementation(libs.androidx.lifecycle.viewmodel.compose) // ViewModel support for Compose

        //Networking
        implementation(libs.retrofit)
        implementation(libs.converter.gson)

        // Image loading library
        implementation(libs.coil.compose) // Coil for image loading in Compose


        implementation(libs.hilt.android)
        implementation(libs.hilt.android.compiler)

        // Kotlin standard library and coroutines
        implementation(libs.kotlin.stdlib)
        implementation(libs.kotlinx.coroutines.core)
        implementation(libs.kotlinx.coroutines.android)



        implementation(libs.hilt.android.v231alpha)
        kapt(libs.hilt.android.compiler.v231alpha)
        implementation(libs.hilt.core)



        // Material Design 3 components
        implementation(libs.androidx.material3)

        // LiveData support
        implementation(libs.androidx.runtime.livedata)



        // Testing libraries
        testImplementation(libs.junit) // JUnit for unit testing
        androidTestImplementation(libs.androidx.junit) // AndroidX JUnit for Android testing
        androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
        androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for consistent versions in tests
        androidTestImplementation(libs.androidx.ui.test.junit4) // JUnit4 support for Compose tests

        // Debugging libraries
        debugImplementation(libs.androidx.ui.tooling) // Tooling support for Compose debugging
        debugImplementation(libs.androidx.ui.test.manifest) // Manifest support for Compose tests
    }


}
kapt {
    correctErrorTypes = true
}