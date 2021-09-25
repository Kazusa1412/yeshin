/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.reflect.KClass

public typealias YeshinEventHandler<T> = suspend T.() -> Unit

private val eventExceptionHandler = CoroutineExceptionHandler { context, throwable ->
    val valueClass = context[CoroutineName]?.name.toString()
    println("Exception in [YeshinEvent<$valueClass>] broadcast:")
    throwable.printStackTrace()
}

/**
 * 为啥不用 [kotlinx.coroutines.channels.BroadcastChannel]
 */
public class YeshinEvent<T : Any>(clazz: KClass<T>) {

    public companion object {
        public inline operator fun <reified T : Any> invoke(): YeshinEvent<T> = YeshinEvent(T::class)

    }

    private val handlers = mutableMapOf<YeshinEventHandler<T>, CoroutineContext>()

    private val scope = CoroutineScope(
        SupervisorJob()
                + CoroutineName(clazz.simpleName.toString() + "Event")
                + eventExceptionHandler
    )

    public fun subscribe(context: CoroutineContext = EmptyCoroutineContext, handler: YeshinEventHandler<T>) {
        handlers += handler to context
    }

    public fun unsubscribe(handler: YeshinEventHandler<T>) {
        handlers -= handler
    }

    public operator fun plusAssign(
        handler: YeshinEventHandler<T>
    ): Unit = subscribe(EmptyCoroutineContext, handler)

    public operator fun minusAssign(handler: YeshinEventHandler<T>): Unit = unsubscribe(handler)

    public operator fun invoke(value: T, context: CoroutineContext = EmptyCoroutineContext) {
        for ((handler, ct) in handlers) {
            scope.launch(context + ct) {
                handler(value)
            }
        }
    }
}
