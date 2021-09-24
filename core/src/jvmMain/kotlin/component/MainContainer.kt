/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.elouyi.yeshin.component.model.YeshinModel
import kotlinx.coroutines.CoroutineScope


public class MainContainer(
    override val state: MutableState<YeshinModel<*>>,
    private val componentScope: CoroutineScope
) : RComponent<YeshinModel<*>> {

    @Composable
    override fun render() {
        Column(modifier = Modifier.background(Color.Green)) {
            state.value.render()
        }

    }

    public companion object : RComponent.K<MainContainer, YeshinModel<*>>
}
