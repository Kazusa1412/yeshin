/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin.component.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import com.elouyi.yeshin.YeshinEvent
import com.elouyi.yeshin.component.RComponent
import com.elouyi.yeshin.utils.YeshinExperimental


@YeshinExperimental
public interface YeshinModel<S> : RComponent<S> {

    public val title: String

    public val icon: ImageBitmap

    public val position: Int

    @Composable
    public override fun render() {
    }

    public companion object {

        public val models: MutableList<YeshinModel<*>> = mutableListOf()


        init {
            initModels()
        }

        public val modelChangeEvent: YeshinEvent<YeshinModel<*>> = YeshinEvent()

        private fun initModels() {
            models.addAll(builtinModels.sortedBy { it.position })
            // TODO: 2021/9/24 加载jar
        }

        private val builtinModels: Array<YeshinModel<*>> = arrayOf(
            HomeModel
        )
    }

}

