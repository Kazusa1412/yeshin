/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.elouyi.yeshin.component.model.YeshinModel


public class MainContainer(override val state: MutableState<YeshinModel<*>>) : RComponent<YeshinModel<*>> {

    @Composable
    override fun render() {
        state.value.render()
    }

    public companion object : RComponent.K<MainContainer, YeshinModel<*>>
}
