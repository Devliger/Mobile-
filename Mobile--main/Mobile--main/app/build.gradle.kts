plugins {
    // This applies the plugins that were declared in the top-level file.
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // It's good practice to use a unique namespace.
    // This is often your reverse domain name + app name.
    namespace = "com.motivamais.app"
    compileSdk = 34

    buildFeatures {
        // Habilita o Jetpack Compose
        compose = true
    }

    composeOptions {
        // Define a versão do compilador do Kotlin a ser usada pelo Compose.
        // Verifique a compatibilidade com a sua versão do Kotlin.
        kotlinCompilerExtensionVersion = "1.5.10" // Use a versão compatível
    }

    packaging {
        // ...
    }

    defaultConfig {
        // This must be unique for the Google Play Store.
        applicationId = "com.motivamais.app"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


dependencies {
    // This is where you add your libraries.
    // Here are some standard ones to get you started.
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(platform("androidx.compose:compose-bom:2023.08.00")) // BOM para gerenciar versões
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    // Dependencies for testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3") // Ou a versão mais recente
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
    implementation("androidx.compose.runtime:runtime-livedata")

}
}
