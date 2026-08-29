package com.example.andegym.ui.trainig

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andegym.R
import com.example.andegym.data.model.ExercisePlan

@Composable
fun CardGym(weight:Float,
            increaseWeight: ()->Unit,
            decreaseWeight:()->Unit,
            exercise: ExercisePlan?){
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp)),
    ){
        Column(modifier=Modifier.padding(16.dp), horizontalAlignment = Alignment.Start)
        {
            Text(
                text= exercise?.name ?: "Упражнение",
                fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 16.sp,
                color=Color(0xFFE0E0E0)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text="${exercise?.sets ?: 0} подхода × ${exercise?.reps ?: 0} повторов",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                color=Color(0xFFA0A0A0)
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    tint=Color(0xFF6C5CE7),
                    contentDescription = "weight",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text= "${weight.toInt()} кг",
                    fontFamily = FontFamily(Font(R.font.jura_bold)),
                    color=Color(0xFFE0E0E0),
                    fontSize = 32.sp
                )
            }
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),modifier=Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ){
                Button(onClick = decreaseWeight, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),shape=RoundedCornerShape(16.dp), modifier = Modifier
                    .height(48.dp)
                    .weight(1f))
                {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            imageVector = Icons.Default.Remove,
                            tint=Color(0xFFE0E0E0),
                            contentDescription = "DEC",
                            modifier= Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text="-2.5 КГ",
                            fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                            fontSize = 14.sp,
                            color=Color(0xFFE0E0E0)
                        )
                    }
                }
                Button(onClick = increaseWeight, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),shape=RoundedCornerShape(16.dp), modifier = Modifier
                    .height(48.dp)
                    .weight(1f))
                {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ){
                        Icon(
                            imageVector = Icons.Default.Add,
                            tint=Color.White,
                            contentDescription = "INC",
                            modifier= Modifier.size(24.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text="+2.5 КГ",
                            fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                            fontSize = 14.sp,
                            color=Color.White
                        )
                    }
                }
            }
        }
    }
}
