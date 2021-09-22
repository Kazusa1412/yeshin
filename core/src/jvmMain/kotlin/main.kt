/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin

import androidx.compose.desktop.DesktopMaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
public fun App() {
    DesktopMaterialTheme {
        Text("hello")
    }
}

private fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
