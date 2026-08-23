package com.example.andegym.ui.dashboard



import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
fun HowReady(){
    Card(colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)), modifier = Modifier
        .fillMaxWidth()
        .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        .border(1.dp, Color(0xFF3A3A3A), RoundedCornerShape(16.dp))){
        Column(


            modifier=Modifier
                .fillMaxWidth()
                .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Default.Bedtime,
                    contentDescription="",
                    tint=Color(0xFF6C5CE7),
                    modifier=Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text="Готовность",
                    fontSize = 15.sp,
                    color = Color(0xFFA0A0A0)

                )

            }
            Spacer(Modifier.height(8.dp))
            Text(
                text="87%",
                fontSize = 40.sp,
                fontFamily = FontFamily(Font(R.font.jura_bold)),
                color=Color(0xFFE0E0E0)

            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Ты в порядке. Жми.",
                fontSize = 15.sp,
                color = Color(0xFF6C5CE7)
            )
        }
    }
}