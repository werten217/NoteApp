// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id ("com.google.devtools.ksp") version "2.1.10-1.0.31" apply false
    id("androidx.navigation.safeargs.kotlin") version "2.8.9" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
}