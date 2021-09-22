/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils

import androidx.compose.runtime.Composable


@YeshinKeywordDsl
@Suppress("Nothing_To_Inline")
public inline fun composable(noinline block: @Composable () -> Unit): @Composable () -> Unit = block
