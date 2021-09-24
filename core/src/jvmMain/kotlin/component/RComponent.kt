/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin.component

import androidx.compose.runtime.*
import com.elouyi.yeshin.utils.YeshinExperimental
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

public interface Component {

    @Composable
    public fun render()
}

/**
 * 提供state
 *
 * 如果 [S] 为对象，可使用 [com.elouyi.yeshin.utils.ShallowCopyable] 浅拷贝来刷新 state
 */
@YeshinExperimental
public interface RComponent<S> : Component {

    public val state: MutableState<S>

    /**
     * 子类记得加 [Composable] 注解
     */
    @Composable
    @YeshinExperimental
    public override fun render() {

    }

    /**
     * 子类伴生对象需要实现此接口
     */
    @YeshinExperimental
    public interface K<C : RComponent<S>, S>

}

@YeshinExperimental
public abstract class RComponentBase<S>(override val state: MutableState<S>) : RComponent<S>

@PublishedApi
@YeshinExperimental
internal val componentMap: MutableMap<Int, RComponent<*>> = mutableMapOf()

@PublishedApi
@Composable
@Suppress("Unused")
@YeshinExperimental
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
@YeshinExperimental
@Composable
public inline operator fun <reified C : RComponent<S>, S> RComponent.K<C, S>.invoke(initState: S) {
    for ((c, rc) in componentMap) {
        // !循环中的组件可能 key 相同
        if (c == currentComposer.compoundKeyHash && rc::class == C::class) {
            rc.render()
            return
        }
    }
    newInstance(initState, currentComposer.compoundKeyHash).render()
}
