/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.component

import androidx.compose.runtime.*
import com.elouyi.yeshin.utils.internal.toPrint
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure


public interface RComponent<S> {

    public val state: MutableState<S>

    @Composable
    public open fun render() {

    }

    public interface K<C : RComponent<S>, S>

}

public abstract class RComponentBase<S>(override val state: MutableState<S>) : RComponent<S>

@PublishedApi
internal val componentMap: MutableMap<Int, RComponent<*>> = mutableMapOf()

@PublishedApi
@Composable
internal inline fun <reified C : RComponent<S>, S> RComponent.K<C, S>.newInstance(state: S, composerKey: Int): C {
    val c = C::class.run cr@{
        val pc = primaryConstructor
        pc?.parameters?.run ppr@{
            if (size != 1) return@ppr
            val pp = get(0)
            if (pp.type.jvmErasure == MutableState::class) {
                return@cr pc
            }
        }
        constructors.find {
            val ps = it.parameters
            if (ps.size != 1) return@find false
            val p = ps[0]
            if (p.type.jvmErasure !is MutableState<*>) return@find false
            true
        }
    } ?: error("cant find RComponent constructor for state")
    val s = remember { mutableStateOf(state) }
    val new = c.call(s)
    componentMap[composerKey] = new
    return new
}

@OptIn(InternalComposeApi::class)
@Composable
public inline operator fun <reified C : RComponent<S>, S> RComponent.K<C, S>.invoke(initState: S) {
    println("invoke")
    println("size is ${componentMap.size}")
    // (componentMap[currentComposer] as? C ?: newInstance(initState, currentComposer)).render()

    for ((c, rc) in componentMap) {
        println("compare key")
        if (c == currentComposer.compoundKeyHash && rc::class == C::class) {
            rc.render()
            return
        }
    }
    newInstance(initState, currentComposer.compoundKeyHash).render()
}


