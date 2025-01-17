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

package com.sergiobelda.compose.catalog.colorpicker.ui

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.unit.sp
import com.sergiobelda.compose.catalog.colorpicker.R

val workSansMedium = font(R.font.work_sans_medium, weight = FontWeight.Medium)

val workSansFontFamily = fontFamily(listOf(workSansMedium))

val typography = Typography(
    body1 = TextStyle(
        fontFamily = workSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 1.25.sp
    ),
    button = TextStyle(
        fontFamily = workSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    caption = TextStyle(
        fontFamily = workSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    h6 = TextStyle(
        fontFamily = workSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 21.sp
    )
)