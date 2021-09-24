/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin.utils

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor


public actual fun <T : ShallowCopyable> T.shallowCopy(): T {
    @Suppress("Unchecked_Cast")
    val clazz = this::class as KClass<T>
    return clazz.primaryConstructor!!.let { pc ->
        pc.parameters.associateWith { p ->
            clazz.declaredMemberProperties
                .first { it.name == p.name }
                .get(this)
        }.let(pc::callBy)
    }
}
