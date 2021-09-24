/*
 * Use of this source code is governed by the GNU AFFERO GENERAL PUBLIC LICENSE Version 3.
 *
 * https://github.com/Kazusa1412/yeshin/blob/main/LICENSE
 *
 */


package com.elouyi.yeshin.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.elouyi.yeshin.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random


public class Head(state: MutableState<String>) : RComponentBase<String>(state) {

    public companion object : RComponent.K<Head, String>

    init {
        GlobalScope.launch {
            delay(100)
            while (true) {
                delay(1000)
                state.value = System.currentTimeMillis().toString()
            }
        }
    }

    @Composable
    override fun render() {
        Column {
            val wk33 by Resource.Icon.PNG
            Image(
                wk33,
                "sa",
                modifier = Modifier.size(40.dp).clip(CircleShape)
            )
        }
        Text(state.value, fontSize = 2.em)
    }

    @Composable
    public fun test() {
        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            if (name.isNotEmpty()) {
                Text(
                    text = "Hello, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.h5
                )
            }
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )
        }
    }

}
