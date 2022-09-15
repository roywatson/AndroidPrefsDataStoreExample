package com.delasystems.androidprefsdatastoreexample.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.delasystems.androidprefsdatastoreexample.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val fonts = FontFamily(
    Font(R.font.rosario_light, weight = FontWeight.Light),
    Font(R.font.rosario_regular, FontWeight.Normal)
)