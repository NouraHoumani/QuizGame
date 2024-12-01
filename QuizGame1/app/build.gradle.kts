plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.techmania.quizgame1"
    compileSdk = 35  // Update compileSdk to 35

    defaultConfig {
        applicationId = "com.techmania.quizgame1"
        minSdk = 24
        this.targetSdk = 35  // Update targetSdk to 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

        buildFeatures {
            viewBinding = true  // Enables View Binding
            compose = true  // Enables Jetpack Compose
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"  // Ensure compatibility with the Kotlin compiler extension version
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"  // Exclude unnecessary resources from the APK
        }
    }
}

dependencies {
    // Core AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Jetpack Compose Libraries
    implementation(platform(libs.androidx.compose.bom))  // BOM for Compose
    implementation(libs.androidx.ui)  // Basic Compose UI
    implementation(libs.androidx.ui.graphics)  // Compose graphics
    implementation(libs.androidx.ui.tooling.preview)  // Preview support
    implementation(libs.androidx.material3)  // Material 3 components
    implementation(libs.androidx.appcompat)  // AppCompat support
    implementation(libs.material)  // Material components (legacy)
    implementation(libs.androidx.activity)  // Activity support



    // Layout and UI Libraries
    implementation(libs.androidx.constraintlayout)  // ConstraintLayout for Compose

    // Unit Testing
    testImplementation(libs.junit)  // JUnit for unit tests

    // UI Testing
    androidTestImplementation(libs.androidx.junit)  // JUnit for Android tests
    androidTestImplementation(libs.androidx.espresso.core)  // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom))  // BOM for Compose testing
    androidTestImplementation(libs.androidx.ui.test.junit4)  // JUnit4 testing for Compose

    // Debugging & Tooling
    debugImplementation(libs.androidx.ui.tooling)  // Tooling for Compose preview
    debugImplementation(libs.androidx.ui.test.manifest)  // UI testing manifest for Compose




}
