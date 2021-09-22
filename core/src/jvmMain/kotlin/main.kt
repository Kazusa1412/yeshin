/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.elouyi.yeshin.ui.App

public fun main(args: Array<String>): Unit = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
