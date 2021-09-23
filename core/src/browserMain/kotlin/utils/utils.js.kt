/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils


public actual fun <T : ShallowCopyable> T.shallowCopy(): T {
    val constructor = this::class.js.asDynamic()
    val newInstance = js("{}")
    newInstance.__proto__ = constructor.prototype
    val parameters = (1..Int.MAX_VALUE).takeWhile {
        constructor.prototype["component$it"] !== undefined
    }.map {
        constructor.propotype["component$it"].call(this).unsafeCast<Any>()
    }.toTypedArray()
    constructor.apply(newInstance, parameters)
    return newInstance as T
}
