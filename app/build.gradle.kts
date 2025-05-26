import java.util.Properties

val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localPropertiesFile.inputStream().use { localProperties.load(it) }
}
val mapkitApiKey = localProperties.getProperty("MAPKIT_API_KEY", "")

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.msdk_ardupilot"
    compileSdk = 35
    useLibrary("org.apache.http.legacy")

    packagingOptions{
        doNotStrip("*/*/libdjivideo.so")
        doNotStrip("*/*/libSDKRelativeJNI.so")
        doNotStrip("*/*/libFlyForbid.so")
        doNotStrip("*/*/libduml_vision_bokeh.so")
        doNotStrip("*/*/libyuv2.so")
        doNotStrip("*/*/libGroudStation.so")
        doNotStrip("*/*/libFRCorkscrew.so")
        doNotStrip("*/*/libUpgradeVerify.so")
        doNotStrip("*/*/libFR.so")
        doNotStrip("*/*/libDJIFlySafeCore.so")
        doNotStrip("*/*/libdjifs_jni.so")
        doNotStrip("*/*/libsfjni.so")
        doNotStrip("*/*/libc++_shared.so")
        doNotStrip("*/*/libmrtc_core_jni.so")
        doNotStrip("*/*/libDJIRegister.so")
        doNotStrip("*/*/libDJIUpgradeJNI.so")
        exclude("META-INF/rxjava.properties")
        jniLibs {
            excludes += setOf("META-INF/**")
        }

    }

    defaultConfig {
        applicationId = "com.example.msdk_ardupilot"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        ndk {
            // On x86 devices that run Android API 23 or above, if the application is targeted with API 23 or
            // above, FFmpeg lib might lead to runtime crashes or warnings.
            abiFilters += setOf("armeabi-v7a", "arm64-v8a")
        }

        buildConfigField("String", "MAPKIT_API_KEY", "\"${mapkitApiKey}\"")
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
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
    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
}

dependencies {
    implementation("com.yandex.android:maps.mobile:4.5.0-full")
    implementation("io.dronefleet.mavlink:mavlink:1.1.11")
    implementation("io.dronefleet.mavlink:mavlink-protocol:1.1.11")
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}