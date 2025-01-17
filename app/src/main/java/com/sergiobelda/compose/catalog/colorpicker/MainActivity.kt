/*
 * Copyright 2020 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sergiobelda.compose.catalog.colorpicker

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.sergiobelda.compose.catalog.colorpicker.ui.ColorPickerTheme
import com.sergiobelda.compose.colorpicker.ColorPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPickerTheme {
                BottomSheet()
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun BottomSheet() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val dialogState = remember { mutableStateOf(false)  }
    val colors = listOf(
        null,
        Color(0xFF000000),
        Color(0xFFFFFFFF),
        Color(0xFFFAFAFA),
        Color(0x80FF4444),
        Color(0xFFEF5350),
        Color(0xFFEC407A),
        Color(0xFFAB47BC),
        Color(0xFF7E57C2),
        Color(0xFF5C6BC0),
        Color(0xFF42A5F5),
        Color(0xFF29B6F6),
        Color(0xFF26C6DA),
        Color(0xFF26A69A),
        Color(0xFF66BB6A),
        Color(0xFF9CCC65),
        Color(0xFFD4E157),
        Color(0xFFFFEE58),
        Color(0xFFFFCA28),
        Color(0xFFFFA726),
        Color(0xFFFF7043)
    )
    val (selectedColor, onColorSelected) = remember { mutableStateOf(colors[0]) }
    BottomSheetScaffold(
        sheetContent = {
            Column {
                Text(
                    "Select color",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(12.dp)
                )
                Divider(thickness = 1.dp, color = MaterialTheme.colors.onPrimary)
                ColorPicker(
                    colors,
                    selectedColor,
                    onColorSelected,
                    modifier = Modifier.padding(12.dp).align(Alignment.CenterHorizontally)
                )
            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(selectedColor ?: Color.White)
        ) {
            Button(
                onClick = { scaffoldState.bottomSheetState.expand() }
            ) {
                Text("Open BottomSheet")
            }
            Button(
                onClick = { dialogState.value = true }
            ) {
                Text("Open Dialog")
            }
        }
        if (dialogState.value) {
            AlertDialog(
                onDismissRequest = { dialogState.value = false },
                title = {
                    Text(
                        "Select color",
                        style = MaterialTheme.typography.body1
                    )
                },
                text = {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        ColorPicker(
                            colors,
                            selectedColor,
                            onColorSelected,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                    }
                },
                confirmButton = {
                    Button(onClick = { dialogState.value = false }) {
                        Text("OK")
                    }
                }
            )
        }
    }
}
