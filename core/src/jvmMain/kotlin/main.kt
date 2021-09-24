/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.elouyi.yeshin.ui.App
import kotlin.system.exitProcess

public fun main(args: Array<String>) {
    application {
        Window(
            onCloseRequest = { exitProcess(0) },
            title = "Yeshin",
            icon = BitmapPainter(Resource.Icon.ayaka)
        ) {
            App()
        }
    }
}
