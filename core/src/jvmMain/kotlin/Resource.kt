/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import kotlin.reflect.KProperty


public object Resource {

    public object Icon {
        public val wk33: ImageBitmap by lazy { loadBitmap("icon/wk33.png") }

        public object PNG {
            public operator fun getValue(p1: Any?, prop: KProperty<*>): ImageBitmap {
                return loadBitmap("icon/${prop.name}.png")
            }
        }

    }
}

public fun loadBitmap(path: String): ImageBitmap {
    return useResource(path, ::loadImageBitmap)
}