/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.elouyi.yeshin.Resource
import com.elouyi.yeshin.component.Head
import com.elouyi.yeshin.component.invoke

@Composable
public fun App() {

    Row(
        modifier = Modifier
            .background(Brush.linearGradient(listOf(Resource.Colors.bk, Resource.Colors.bk2)))
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.width(400.dp).fillMaxHeight()) {
            Head("5")
        }
        Head("20")
    }
}
