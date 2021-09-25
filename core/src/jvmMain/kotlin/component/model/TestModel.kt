/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.component.model

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import com.elouyi.yeshin.Resource


public object TestModel : YeshinModel<Unit> {

    override val state: MutableState<Unit> = mutableStateOf(Unit)

    override val title: String = "Test"

    override val icon: ImageBitmap = Resource.Icon.wk33

    override val position: Int = 2

    @Composable
    override fun render() {
        Text("Test Model")
    }

}