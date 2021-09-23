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

package com.elouyi.yeshin.model

import androidx.compose.runtime.Composable
import com.elouyi.yeshin.component.RComponent


public abstract class YeshinModel<S> : RComponent<S> {

    public abstract val title: String

    public abstract val icon: String

    public abstract val position: Int

    @Composable
    public override fun render() {
    }

}

