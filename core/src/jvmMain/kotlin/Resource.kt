/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import kotlin.reflect.KProperty

/**
 * 资源
 */
public sealed interface Resource {

    public object Colors {

        public val bk: Color = Color(234, 246, 249)
        public val bk2: Color = Color(233, 255, 255)
    }

    public object Icon {

        public val wk33: ImageBitmap by lazy { loadBitmap("icon/wk33.png") }

        public val ayaka: ImageBitmap by lazy { loadBitmap("icon/ayaka.png") }

        public object PNG {
            public operator fun getValue(p1: Any?, prop: KProperty<*>): ImageBitmap {
                return loadBitmap("icon/${prop.name}.png")
            }
        }

    }
}

/**
 * 从 resources 目录下加载
 */
public fun loadBitmap(path: String): ImageBitmap {
    return useResource(path, ::loadImageBitmap)
}
