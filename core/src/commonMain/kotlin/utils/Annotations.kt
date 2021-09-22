/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils


import kotlin.annotation.AnnotationTarget.*

@Retention(AnnotationRetention.BINARY)
@RequiresOptIn("Yeshin internal api", RequiresOptIn.Level.ERROR)
public annotation class YeshinInternal

@Retention(AnnotationRetention.BINARY)
@RequiresOptIn("记得删掉", RequiresOptIn.Level.WARNING)
public annotation class YeshinDebug

@RequiresOptIn("实验性功能", RequiresOptIn.Level.WARNING)
public annotation class YeshinExperimental

@DslMarker
public annotation class YeshinKeywordDsl
