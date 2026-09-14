package com.example.andegym.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.App
import com.example.andegym.R

import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(viewModel: ProfileViewModel= viewModel(),
                  homeClick:()->Unit,
                  gymClick:()->Unit,
                  friendsListClick:()->Unit,
                  profileClick:()->Unit,
){
    val nickname by viewModel.nickname.collectAsState()
    val xp by viewModel.xpFlow.collectAsState(initial = 0)
    val level = viewModel.getlevel(xp)
    val workoutCount by viewModel.workoutCount.collectAsState()
    val totalVolume by viewModel.totalVolume.collectAsState()
    val firstWorkoutFlow by viewModel.firstWorkoutFlow.collectAsState(initial = false)
    val threeWorkoutFlow by viewModel.threeWorkoutFlow.collectAsState(initial = false)
    val tenWorkoutFlow by viewModel.tenWorkoutFlow.collectAsState(initial = false)
    val earlyBirdFlow by viewModel.earlyBirdFlow.collectAsState(initial = false)

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
            ProfileAvatar(nickname=nickname)
            ScaleOfXP(xp,level)
            Achievements(
                firstWorkout=firstWorkoutFlow,
                threeWorkout=threeWorkoutFlow,
                tenWorkout = tenWorkoutFlow,
                earlyBird=earlyBirdFlow,
                heavyLifter = false
            )
            Statictics(workoutCount = workoutCount, totalVolume = totalVolume)
            Settings()
        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)

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
            text="ПРОФИЛЬ",
            fontFamily = FontFamily(Font(R.font.jura_bold)),
            fontSize = 18.sp,
            color=Color(0xFFE0E0E0),

            )
    }
}


@Composable
fun ProfileAvatar(nickname: String){
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
        text=nickname,
        fontFamily = FontFamily(Font(R.font.manrope_semibold)),
        fontSize = 18.sp,
        color=Color(0xFFE0E0E0),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )


}


@Composable
fun ScaleOfXP(xp:Int,level:Int){
    Column(modifier=Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, start = 16.dp, end = 16.dp)){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(8.dp)
            .background(Color(0xFF2C2C2C), RoundedCornerShape(4.dp))){
            Box(modifier = Modifier
                .fillMaxWidth((xp%100)/100f)
                .height(8.dp)
                .background(Color(0xFF6C5CE7), RoundedCornerShape(4.dp))){
            }
        }
        Spacer(Modifier.height(8.dp))
        Text(
            text="Уровень ${level}",
            fontFamily = FontFamily(Font(R.font.manrope_semibold)),
            fontSize = 14.sp,
            color=Color(0xFF6C5CE7)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text="XP: ${xp}",
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontSize = 12.sp,
            color=Color(0xFFA0A0A0)
        )
    }
}

@Composable
fun Achievements(firstWorkout: Boolean,
                 threeWorkout: Boolean,
                 tenWorkout: Boolean,
                 earlyBird: Boolean,
                 heavyLifter: Boolean){
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
                                    tint=if(firstWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Первая кровь",
                                    color=if(firstWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=if(threeWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Ты всё ещё здесь?",
                                    color=if(threeWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=if(earlyBird) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Жаворонок",
                                    color=if(earlyBird) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
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
                                    tint=if(heavyLifter) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Мешок картошки",
                                    color=if(heavyLifter) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_regular))
                                )
                            }
                            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
                                modifier=Modifier.weight(1f)) {
                                Icon(
                                    imageVector = Icons.Default.EmojiEvents,
                                    tint=if(tenWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
                                    contentDescription = "achievement",
                                    modifier = Modifier.size(32.dp)
                                )

                                Text(
                                    text="Батя в зале",
                                    color=if(tenWorkout) Color(0xFF6C5CE7) else Color(0xFF3A3A3A),
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
fun Statictics(workoutCount: Int, totalVolume: Int){
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
                        text="Всего тренировок: "+workoutCount,
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 13.sp,
                        color=Color(0xFFA0A0A0)
                    )
                    Text(
                        text="Часов в зале: "+(workoutCount * 1.5).toInt(),
                        fontFamily = FontFamily(Font(R.font.manrope_regular)),
                        fontSize = 13.sp,
                        color=Color(0xFFA0A0A0)
                    )
                    Text(
                        text="Общий объём: "+totalVolume,
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
