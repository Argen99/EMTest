plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.devtools.ksp)
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        viewBinding = true
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature-auth:domain"))
    implementation(project(":feature-main:main-domain"))
    implementation(project(":feature-favorites:favorites-domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.koin.android)
    implementation(libs.coroutines.android)
    implementation(libs.bundles.networking)
    implementation(libs.room.room)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
}