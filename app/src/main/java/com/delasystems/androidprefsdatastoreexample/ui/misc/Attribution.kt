/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.delasystems.androidprefsdatastoreexample.ui.misc

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delasystems.androidprefsdatastoreexample.ui.theme.fonts

@Composable
fun Attribution() {
    Text(
        text = "Sample Code by:",
        fontSize = 18.sp,
    )
    Text(
        text = "R O Y  W A T S O N",
        fontFamily = fonts,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
    )
    Text(
        text = "rwatson@dela.com",
        fontSize = 22.sp,
    )
    Text(
        text = "www.dela.com",
        fontSize = 22.sp,
        modifier = Modifier.padding(start = 0.dp, top = 5.dp, end = 0.dp, bottom = 15.dp)
    )

}