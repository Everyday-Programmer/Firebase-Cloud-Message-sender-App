plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.firebaseadminandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.firebaseadminandroid"
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

    packagingOptions.resources.excludes.add("META-INF/io.netty.versions.properties")
    packagingOptions.resources.excludes.add("META-INF/INDEX.LIST")
    packagingOptions.resources.excludes.add("mozilla/public-suffix-list.txt")
    packagingOptions.resources.excludes.add("META-INF/DEPENDENCIES")
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.firebase.admin)
}