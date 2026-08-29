package com.example.andegym.ui.trainig

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andegym.R

@Composable
fun TimerRest(timer: Long){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(Modifier.height(12.dp))
        Text(
            text="Отдых",
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontSize = 14.sp,
            color=Color(0xFFFF6B6B)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text="${timer / 60}:${(timer % 60).toString().padStart(2, '0')}",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 48.sp,
            color=Color(0xFFE0E0E0)
        )
    }
}