/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils

import androidx.compose.runtime.Composable
import kotlin.math.abs


@YeshinKeywordDsl
@Suppress("Nothing_To_Inline")
public inline fun composable(noinline block: @Composable () -> Unit): @Composable () -> Unit = block

@Suppress("UNCHECKED_CAST")
public val <T : Number> T.abs: T
    get() = when (this) {
        is Int -> abs(this) as T
        is Double -> abs(this) as T
        is Float -> abs(this) as T
        is Long -> abs(this) as T
        else -> error("")
    }
