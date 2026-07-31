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
import com.example.andegym.ui.theme.AndeGymTheme


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
fun TopBarHome(){
    Row(modifier = Modifier
        .height(56.dp)
        .fillMaxWidth()
        .background(Color(0xFF1A1A1A))
        .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,)
    {
        Icon(
            imageVector = Icons.Default.Pets,
            contentDescription = "Иконка приложения",
            tint=Color(0xFF6C5CE7),
            modifier = Modifier.size(24.dp),
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text ="GrandGym",
            fontSize = 20.sp,
            color = Color(0xFFE0E0E0),
            fontFamily = FontFamily(Font(R.font.jura_bold))
        )
        Spacer(Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Уведомления",
            tint=Color(0xFFE0E0E0),
            modifier = Modifier.size(24.dp),
        )
    }
}

@Composable
fun TopBarGym(){
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
            text="ТРЕНИРОВКА",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),

        )
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
            text="Свои",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),

            )
    }

}

@Composable
fun TopBarProfile(){
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
            text="Профиль",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),

            )
    }
}

@Composable
fun VideoAnaliz(){
    Card(
        modifier = Modifier
            .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            .height(240.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),

    ){
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
            Icon(
                imageVector = Icons.Default.Videocam,
                tint=Color(0xFF666666),
                contentDescription = "VideoCam",
                modifier = Modifier.size(48.dp),

                )
        }

    }
}

@Composable
fun CardGym(){
    Box(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp)),
    ){
        Column(modifier=Modifier.padding(16.dp), horizontalAlignment = Alignment.Start)
        {
            Text(
                text="Приседания",
                fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                fontSize = 16.sp,
                color=Color(0xFFE0E0E0)
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text="Подход 3 из 4",
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
                    text="95кг",
                    fontFamily = FontFamily(Font(R.font.jura_bold)),
                    color=Color(0xFFE0E0E0),
                    fontSize = 32.sp
                )
                }

        }
    }
}

@Composable
fun ButtonGym(){
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),modifier=Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ){
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),shape=RoundedCornerShape(16.dp), modifier = Modifier
            .height(48.dp)
            .weight(1f))
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Pause,
                    tint=Color(0xFFE0E0E0),
                    contentDescription = "PAUSE",
                    modifier= Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text="ПАУЗА",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 14.sp,
                    color=Color(0xFFE0E0E0)
                )
            }
        }
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B6B)),shape=RoundedCornerShape(16.dp), modifier = Modifier
            .height(48.dp)
            .weight(1f))
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Stop,
                    tint=Color.White,
                    contentDescription = "STOP",
                    modifier= Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text="ЗАВЕРШИТЬ",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 14.sp,
                    color=Color.White
                )
            }
        }
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
fun TextTip(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ){
        Spacer(Modifier.height(8.dp))
        Text(
            text="Спина сутулится",
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontSize = 14.sp,
            color=Color(0xFFFF6B6B)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text="0:37",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 48.sp,
            color=Color(0xFFE0E0E0)
        )
    }
}

@Composable
fun Hello(){
    Row(

        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 24.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text="С возвращением, Ваня",
                fontSize = 14.sp,
                color = Color(0xFFA0A0A0)
            )
            Text(
                text="ПОГНАЛИ",
                fontSize = 36.sp,
                fontFamily = FontFamily(Font(R.font.jura_bold)),
                color=Color(0xFFE0E0E0)
            )
            Text(
                text="Сегодня твой день",
                fontSize = 14.sp,
                color=Color(0xFF6C5CE7)
            )
        }
        Spacer(Modifier.width(16.dp))
        Icon(
            imageVector = Icons.Default.FitnessCenter,
            contentDescription = "Маскот должен быть",
            tint=Color(0xFFE0E0E0),
            modifier = Modifier.size(120.dp),
        )
    }
}

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

@Composable
fun StartGym(
    startGymClick: () -> Unit
){
    Button(onClick = startGymClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6C5CE7)),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 40.dp, end = 16.dp)
            .height(70.dp))
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

        ){
            Icon(
                imageVector = Icons.Default.ArrowForward,
                tint = Color.White,
                contentDescription = "Start",
                modifier= Modifier.size(24.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text="НАЧАТЬ",
                fontFamily = FontFamily(Font(R.font.jura_bold)),
                fontSize = 16.sp,
                color=Color.White
            )
        }
    }
}

@Composable
fun Exercises(){
    Text(
        text="План на сегодня",
        fontSize = 14.sp,
        fontFamily=FontFamily(Font(R.font.manrope_semibold)),
        color=Color(0xFFA0A0A0),
        modifier=Modifier.padding(top=24.dp,start=16.dp)
    )
    Spacer(Modifier.height(12.dp))
    class Exercise(val name:String,val number:String)
    val listExercises=mutableListOf(Exercise("Жим лежа","4x8"),Exercise("Присед","3x10"),Exercise("Становая","4x6"),Exercise("Подтягивания","15x3"))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(start=16.dp)
    )
    {items(listExercises){
        item->
        Card(
            shape = RoundedCornerShape(12.dp),
            colors=CardDefaults.cardColors(containerColor = Color(0xFF2C2C2C)),
            modifier = Modifier
                .height(100.dp)
                .width(140.dp)
        )
    {
            Column(modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center)
            {
                Text(
                    text=item.name,
                    fontFamily=FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 16.sp,
                    color = Color(0xFFE0E0E0)
                    )
                Spacer(Modifier.height(6.dp))
                Text(
                    text=item.number,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 14.sp,
                    color=Color(0xFFA0A0A0)
                )
                Icon(
                    imageVector = Icons.Default.FitnessCenter,
                    tint=Color(0xFF6C5CE7),
                    contentDescription = "Иконка упраженения",
                    modifier=Modifier.size(25.dp)
                )
            }
    }
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


@Composable
fun HomeScreen(
    startGymClick:()->Unit,
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
            TopBarHome()
            Hello()
            HowReady()
            StartGym(startGymClick)
            Exercises()
        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
    }
}

@Composable
fun TrainingScreen(
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
            TopBarGym()
            VideoAnaliz()
            TextTip()
            CardGym()
            ButtonGym()
        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
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
fun ProfileScreen(
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

            TopBarProfile()
            ProfileAvatar()
            ScaleOfXP()
            Achievements()
            Statictics()
            Settings()
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



@Composable
fun ProfileAvatar(){
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .size(96.dp)
                .border(2.dp, Color(0xFF6C5CE7), CircleShape)
                .background(Color(0xFF2C2C2C), CircleShape)
        , contentAlignment = Alignment.Center){
            Icon(
                imageVector = Icons.Default.Pets,
                contentDescription = "",
                tint=Color(0xFF6C5CE7),
                modifier = Modifier.size(64.dp)
            )
        }
    }
    Spacer(Modifier.height(12.dp))

        Text(
            text="Ваня",
            fontFamily = FontFamily(Font(R.font.manrope_semibold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )


}


@Composable
fun ScaleOfXP(){
    Column(modifier=Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(4.dp))){
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(8.dp)
                .background(Color(0xFF6C5CE7), RoundedCornerShape(4.dp))){
            }
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text="Уровень 5",
            fontFamily = FontFamily(Font(R.font.manrope_semibold)),
            fontSize = 14.sp,
            color=Color(0xFF6C5CE7)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text="XP: 2 450 / 5 000",
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontSize = 12.sp,
            color=Color(0xFFA0A0A0)
        )
    }
}

@Composable
fun Achievements(){
    Box(Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 24.dp)){
        Box(Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))){
            Column(){
                Row(){
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        tint=Color(0xFFE0E0E0),
                        contentDescription = "Achievements",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text="Достижения",
                        fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                        fontSize = 16.sp,
                        color=Color(0xFFE0E0E0),

                    )

                }
                Row(){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly){
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=Color(0xFF6C5CE7),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Первая кровь",
                                    color=Color(0xFF6C5CE7),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=Color(0xFF6C5CE7),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Ты всё ещё здесь?",
                                    color=Color(0xFF6C5CE7),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=Color(0xFF6C5CE7),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Жаворонок",
                                    color=Color(0xFF6C5CE7),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                        Row(modifier=Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceEvenly){
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Мешок картошки",
                                    color=Color(0xFF3A3A3A),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Батя в зале",
                                    color=Color(0xFF3A3A3A),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) { }

                        }
                    }
                }

            }

        }
    }
}


@Composable
fun Statictics(){
    Box(modifier=Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp)){
        Box(Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))){
            Column {
                Row{
                    Icon(
                        imageVector = Icons.Default.BarChart,
                        tint=Color(0xFFE0E0E0),
                        contentDescription = "BARCHART",
                        modifier=Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text="Статистика",
                        fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                        fontSize = 16.sp,
                        color=Color(0xFFE0E0E0)
                    )
                }
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)){
                    Text(
                        text="Всего тренировок: 47",
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 13.sp,
                        color=Color(0xFFA0A0A0)
                    )
                    Text(
                        text="Часов в зале: 32",
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 13.sp,
                        color=Color(0xFFA0A0A0)
                    )
                    Text(
                        text="Общий объём: 127 500кг",
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 13.sp,
                        color=Color(0xFFA0A0A0)
                    )
                }
            }

        }
    }
}


@Composable
fun Settings(){
    Box(Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp, end = 16.dp)){
        Box(Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(12.dp))){
            Column{
                Row{
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint=Color(0xFFE0E0E0),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text="Настройки",
                        fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                        fontSize = 16.sp,
                        color=Color(0xFFE0E0E0)
                    )
                }
                Column(modifier=Modifier.padding(top=12.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            imageVector = Icons.Default.FitnessCenter,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text="Цель:Сила",
                            fontFamily = FontFamily(Font(R.font.manrope_regular)),
                            fontSize = 14.sp,
                            color=Color(0xFFE0E0E0)
                        )
                        Spacer(Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            imageVector = Icons.Default.CalendarToday,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text="Дни: ПН · СР · ПТ",
                            fontFamily = FontFamily(Font(R.font.manrope_regular)),
                            fontSize = 14.sp,
                            color=Color(0xFFE0E0E0)
                        )

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )

                    }

                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            imageVector = Icons.Default.Watch,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text="Часы: Подключены",
                            fontFamily = FontFamily(Font(R.font.manrope_regular)),
                            fontSize = 14.sp,
                            color=Color(0xFFE0E0E0)
                        )

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                    Row( modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp),
                        verticalAlignment = Alignment.CenterVertically){
                        Icon(
                            imageVector = Icons.Default.Info,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text="О приложении",
                            fontFamily = FontFamily(Font(R.font.manrope_regular)),
                            fontSize = 14.sp,
                            color=Color(0xFFE0E0E0)
                        )

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            tint=Color(0xFFA0A0A0),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                }
            }
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
