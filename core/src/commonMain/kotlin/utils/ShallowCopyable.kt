/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.utils

/**
 * 让类拥有浅拷贝
 */
public interface ShallowCopyable

/**
 * 浅拷贝
 */
public expect fun <T : ShallowCopyable> T.shallowCopy(): T
