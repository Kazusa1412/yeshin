/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


buildscript {

    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("org.jetbrains.compose:compose-gradle-plugin:${Versions.compose}")
    }
}

allprojects {

    group = "com.elouyi"
    version = "0.0.1"

    repositories {
        maven("https://maven.aliyun.com/nexus/content/groups/public/")
        mavenCentral()
    }
}
