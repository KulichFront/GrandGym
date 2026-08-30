package com.example.andegym

import android.graphics.Paint
import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.CrueltyFree
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Sms
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VideoCall
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material.icons.filled.Wash
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.andegym.AddFriend
import com.example.andegym.navigation.AppNavHost
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.dashboard.HomeScreen
import com.example.andegym.ui.dashboard.HowReady
import com.example.andegym.ui.profile.ProfileScreen
import com.example.andegym.ui.theme.AndeGymTheme
import com.example.andegym.ui.trainig.TrainingScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController= rememberNavController()
            AppNavHost(navHostController = navController)


        }
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically   ){

            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "SEARCH",
                tint=Color(0xFFA0A0A0),
                modifier=Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text="Поиск по нику...",
                fontFamily = FontFamily(Font(R.font.manrope_regular)),
                fontSize = 14.sp,
                color=Color(0xFFA0A0A0)
            )
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
            AddFriend()

        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
    }


}





@Composable
fun Onboarding(
    onNextClick:()-> Unit,
){
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF1A1A1A))
        .statusBarsPadding()
        .navigationBarsPadding(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = Icons.Default.Pets,
            tint=Color(0xFF6C5CE7),
            contentDescription = "",
            modifier = Modifier.size(120.dp)
        )
        Spacer(Modifier.height(32.dp))
        Text(
            text="ДОБРО ПОЖАЛОВАТЬ",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 24.sp,
            color=Color(0xFFE0E0E0)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text="В GRANDGYM",
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontSize = 16.sp,
            color=Color(0xFFA0A0A0)
        )
        Spacer(Modifier.height(32.dp))
        var name by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp).height(56.dp),
            value = name,
            onValueChange = {name=it},
            placeholder = {
                Text(
                    text="Введи своё имя",
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 16.sp,
                    color = Color(0xFF666666)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color(0xFFE0E0E0),          // цвет текста когда поле активно
                unfocusedTextColor = Color(0xFFE0E0E0),        // цвет текста когда неактивно
                cursorColor = Color(0xFF6C5CE7),               // цвет курсора
                focusedContainerColor = Color(0xFF2C2C2C),     // фон когда активно
                unfocusedContainerColor = Color(0xFF2C2C2C),   // фон когда неактивно
                focusedIndicatorColor = Color.Transparent,     // убрать линию индикатора
                unfocusedIndicatorColor = Color.Transparent    // убрать линию индикатора
            ),
            shape = RoundedCornerShape(12.dp)

        )
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNextClick,
            modifier = Modifier.padding(start=16.dp,end=16.dp).fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C5CE7)),
           shape = RoundedCornerShape(28.dp)
        )
            {
            Text(
                text = "ПОГНАЛИ",
                fontFamily = FontFamily(Font(R.font.jura_bold)),
                fontSize = 16.sp,
                color = Color.White
            )
            }
    }
}









@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun HomePreview() {
    AndeGymTheme {

            HomeScreen(startGymClick = {},
                homeClick = {},
                gymClick = {},
                friendsListClick = {},
                profileClick = {})


    }
}

@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun GymPreview(){
    AndeGymTheme{
        TrainingScreen(homeClick = {},
            gymClick = {},
            friendsListClick = {},
            profileClick = {})
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

@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun ProfilePreview(){
    AndeGymTheme{
        ProfileScreen(homeClick = {},
            gymClick = {},
            friendsListClick = {},
            profileClick = {})
    }
}


@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun OnboardingPreview(){
    AndeGymTheme{
        Onboarding (onNextClick = {})
    }
}
