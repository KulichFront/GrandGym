package com.example.andegym.ui.requests

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andegym.R
import com.example.andegym.data.model.User



@Composable
fun requestCard(user: User,
                onAccept:()->Unit,
                onDecline:()->Unit){
    var isButtonVisible by remember { mutableStateOf(true) }
    if(isButtonVisible==true){
    Box(
        modifier=Modifier

            .fillMaxWidth()
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
    ){
        Column {
            Row(modifier=Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically)
            {
                Box( contentAlignment = Alignment.Center,  modifier = Modifier
                    .size(48.dp)
                    .background(Color(0xFF3A3A3A), RoundedCornerShape(8.dp)))
                {
                    Icon(
                        imageVector = Icons.Default.Person,
                        tint=Color(0xFFE0E0E0),
                        contentDescription = "Friend",
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(Modifier.width(12.dp))
                Column(){
                    Text(
                        text=user.nickname,
                        fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                        fontSize = 16.sp,
                        color=Color(0xFFE0E0E0)
                    )
                    Text(
                        text="ур. "+user.level.toString(),
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 14.sp,
                        color=Color(0xFF6C5CE7)
                    )
                }
                Spacer(Modifier.weight(1f))
                Text(
                    text="Отправил вам заяку в друзья",
                    fontSize = 14.sp,
                    color=Color(0xFF6C5CE7),
                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                )
            }
            Row(modifier = Modifier.padding(horizontal = 16.dp)){
                Button(onClick={
                    onAccept()
                    isButtonVisible=false           }, modifier = Modifier.weight(1f)){
                    Text(
                        text="Добавить",
                        fontSize = 14.sp
                    )
                }
                Spacer(Modifier.width(20.dp))
                Button(onClick={onDecline()
                               isButtonVisible=false}, modifier = Modifier.weight(1f)){
                    Text(
                        text="Отклонить",
                        fontSize = 14.sp
                    )
                }
            }
        }


    }
}
    }




