package com.example.andegym.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Divider
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
fun BottomNavigation(
    homeClick:()->Unit,
    gymClick:()->Unit,
    friendsListClick:()->Unit,
    profileClick:()->Unit,
){
    Column(){
        Divider(color = Color(0xFF2C2C2C), thickness = 1.dp)
        Row(
            Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(Color(0xFF1A1A1A))
        ){
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight().clickable(onClick =homeClick ),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint=Color(0xFF6C5CE7),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text="Главная",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color=Color.White
                )


            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight().clickable(onClick = gymClick),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    contentDescription = "Home",
                    tint=Color(0xFF6C5CE7),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text="Тренировка",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color=Color.White
                )


            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight().clickable(onClick = friendsListClick),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Home",
                    tint=Color(0xFF6C5CE7),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text="Свои",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color=Color.White
                )


            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight().clickable(onClick = profileClick),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Icon(
                    imageVector = Icons.Default.Pets,
                    contentDescription = "Home",
                    tint=Color(0xFF6C5CE7),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text="Профиль",
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color=Color.White
                )


            }
        }
    }
}
