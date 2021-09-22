/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils.internal

import com.elouyi.yeshin.utils.YeshinDebug
import com.elouyi.yeshin.utils.YeshinKeywordDsl

@YeshinDebug
@YeshinKeywordDsl
internal inline val <T> T.toPrint: T
    get() = also(::println)
