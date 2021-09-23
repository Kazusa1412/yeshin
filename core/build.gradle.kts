/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

kotlin {

    explicitApi()

    jvm("jvm")

    js("browser", IR) {
        browser()
        nodejs()
    }

    sourceSets {

        all {
            languageSettings {
                optIn("kotlin.contracts.ExperimentalContracts")
                optIn("kotlin.RequiresOptIn")
                optIn("kotlin.OptIn")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}")
                implementation(compose.runtime)
                implementation("io.ktor:ktor-client-core:${Versions.ktor}")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
                implementation("io.ktor:ktor-client-cio:${Versions.ktor}")
                implementation(kotlin("reflect"))
            }
        }

        val browserMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation("io.ktor:ktor-client-js:${Versions.ktor}")
            }
        }
    }
}
