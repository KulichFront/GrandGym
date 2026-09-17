package com.example.andegym.ui.friends

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.andegym.R

import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.theme.AndeGymTheme

@Composable
fun FriendsListScreen(
    homeClick:()->Unit,
    gymClick:()->Unit,
    friendsListClick:()->Unit,
    profileClick:()->Unit,
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .statusBarsPadding()
            .navigationBarsPadding()

    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ){

            TopBarFriends()
            SearchFriend()
            FriendsList()
            Spacer(Modifier.height(50.dp))
            AddFriend()

        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
    }


}
@Composable
fun TopBarFriends(){
    Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier
        .height(56.dp)
        .fillMaxWidth()) {

        Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color(0xFFE0E0E0),
            contentDescription = "Back",
            modifier = Modifier
                .size(40.dp)
                .padding(start = 16.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text="СВОИ",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),

            )
    }

}

@Composable
fun SearchFriend(){
    var searchText by remember{ mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
            , verticalAlignment = Alignment.CenterVertically   ){
        Spacer(Modifier.width(5.dp))
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "SEARCH",
            tint=Color(0xFFA0A0A0),
            modifier=Modifier.size(20.dp)
        )
        Spacer(Modifier.width(8.dp))
        BasicTextField(
            value =searchText ,
            onValueChange = {searchText=it},
            decorationBox = { innerTextField ->
                if (searchText.isEmpty()) {
                    Text("Поиск по нику...", color = Color(0xFFA0A0A0), fontSize = 14.sp)
                }
                innerTextField()
            },
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color = Color(0xFFA0A0A0)
            ),
            modifier= Modifier.weight(2.5f)

        )
        Button(onClick = {}, modifier = Modifier.weight(1f)){
            Text("Найти")
        }
    }
}

@Composable
fun FriendsList() {
    Box(
        modifier=Modifier

            .fillMaxWidth()
            .padding(top = 12.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
    ){
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
                    text="Дима",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color=Color(0xFFE0E0E0)
                )
                Text(
                    text="Тренировок:42",
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 12.sp,
                    color=Color(0xFFA0A0A0)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text="ур.5",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFF6C5CE7)
            )
        }
    }
    Box(
        modifier=Modifier

            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
    ){
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
                    text="Лена",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color=Color(0xFFE0E0E0)
                )
                Text(
                    text="Тренировок:58",
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 12.sp,
                    color=Color(0xFFA0A0A0)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text="ур.7",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFF6C5CE7)
            )
        }
    }
    Box(
        modifier=Modifier

            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
    ){
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
                    text="Саша",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color=Color(0xFFE0E0E0)
                )
                Text(
                    text="Тренировок:12",
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 12.sp,
                    color=Color(0xFFA0A0A0)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text="ур.3",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFF6C5CE7)
            )
        }
    }

    Box(
        modifier=Modifier

            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
    ){
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
                    text="Катя",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color=Color(0xFFE0E0E0)
                )
                Text(
                    text="Тренировок:35",
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 12.sp,
                    color=Color(0xFFA0A0A0)
                )
            }
            Spacer(Modifier.weight(1f))
            Text(
                text="ур.6",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFF6C5CE7)
            )
        }
    }
}

@Composable
fun AddFriend(){
    Button(onClick = {}, modifier = Modifier
        .height(48.dp)
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp,),colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C5CE7)), shape = RoundedCornerShape(16.dp))
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.PersonAdd,
                tint=Color.White,
                contentDescription = "AddFriend",
                modifier=Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text="Добавить друга",
                fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 14.sp,
                color=Color.White
            )
        }
    }
}


@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun FriendsListPreview(){
    AndeGymTheme{
        FriendsListScreen(homeClick = {},
            gymClick = {},
            friendsListClick = {},
            profileClick = {})

    }
}