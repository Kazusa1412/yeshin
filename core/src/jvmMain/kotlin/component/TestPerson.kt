/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */

package com.elouyi.yeshin.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.setValue
import com.elouyi.yeshin.utils.ShallowCopyable
import com.elouyi.yeshin.utils.shallowCopy
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


public class PersonComponent(personState: MutableState<TestPerson>) : RComponentBase<TestPerson>(personState) {

    init {
        GlobalScope.launch {
            while (true) {
                delay(3000)
                println(state.value)
                val pres = state.value
                state.value.age++
                state.value.name += "b"
                state.value = state.value.shallowCopy()
            }
        }
    }

    @Composable
    override fun render() {
        Column {
            Text(state.value.name)
            Text(state.value.age.toString())
        }
    }

    public companion object : RComponent.K<PersonComponent, TestPerson>
}

public data class TestPerson(
    var name: String,
    var age: Int
) : ShallowCopyable {
    init {
        println("Person 构造")
    }

    override fun toString(): String {
        return super.toString()
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}