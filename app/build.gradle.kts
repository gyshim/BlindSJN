plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Kotlin serialization plugin for type safe routes and navigation arguments
    // 객체 직렬화를 위해 사용. Json 라이브러래ㅣ
    kotlin("plugin.serialization") version "2.0.21"
}

android {
    namespace = "com.glowstudio.android.blindsjn"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.glowstudio.android.blindsjn"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
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

    // Compose Core
    implementation("androidx.compose.ui:ui:1.7.5")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.8.4")

    // Tooling for Compose Preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5")

    // Icons
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.compose.material:material-icons-core:1.7.5")
    implementation("androidx.compose.material:material-icons-extended:1.7.5")

    // Navigation
    implementation ("androidx.navigation:navigation-compose:2.8.4")
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.4")

    // Json serialization (DB 전송하려면 필요함)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    //Retrofit library (서버 통신에 필요)
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // Compose Core
    implementation("androidx.compose.ui:ui:1.7.5")
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.activity:activity-compose:1.9.3")

    // Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.8.4")

    // Tooling for Compose Preview
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.5")

    // Icons
    implementation("androidx.compose.material3:material3:1.3.1")
    implementation("androidx.compose.material:material-icons-core:1.7.5")
    implementation("androidx.compose.material:material-icons-extended:1.7.5")

    // Navigation
    implementation ("androidx.navigation:navigation-compose:2.8.4")
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.4")

    // Json serialization (DB 전송하려면 필요함)
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}