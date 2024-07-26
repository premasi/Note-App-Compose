plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.46" apply false
}
