/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.model

import androidx.compose.runtime.Composable
import com.elouyi.yeshin.ui.Component


public sealed interface YeshinModel : Component {

    public val title: String

    public val icon: String  // todo

    public val position: Int

    @Composable
    public override fun render() {
    }

}

public abstract class YeshinModelBase : YeshinModel {

}
