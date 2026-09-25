package com.example.andegym.ui.friends



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.App
import com.example.andegym.R
import com.example.andegym.data.model.AchievementInfo

import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.theme.AndeGymTheme
import com.example.andegym.viewmodel.FriendProfileViewModel
import com.example.andegym.viewmodel.FriendViewModelFactory
import com.example.andegym.viewmodel.FriendsViewModel
import com.example.andegym.viewmodel.ProfileViewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun FriendProfileScreen(
                        uid: String,
                        viewModel: FriendProfileViewModel= viewModel(factory=FriendViewModelFactory(uid)),
                  homeClick:()->Unit,
                  gymClick:()->Unit,
                  friendsListClick:()->Unit,
                  profileClick:()->Unit,
                        backClick:()->Unit
){
    val nickname by viewModel.nickname.collectAsState()
    val xp by viewModel.xp.collectAsState(initial = 0)
    val level = viewModel.level.collectAsState()

    val firstWorkoutFlow by viewModel.firstWorkout.collectAsState()
    val threeWorkoutFlow by viewModel.threeWorkout.collectAsState()
    val tenWorkoutFlow by viewModel.tenWorkout.collectAsState()
    val earlyBirdFlow by viewModel.earlyBird.collectAsState()
    val heavyLifter by viewModel.heavyLifter.collectAsState()






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

            TopBarProfile(backClick=backClick)
            ProfileAvatar(nickname=nickname)
            ScaleOfXP(xp,level.value)
            Achievements(
                firstWorkout=firstWorkoutFlow,
                threeWorkout=threeWorkoutFlow,
                tenWorkout = tenWorkoutFlow,
                earlyBird=earlyBirdFlow,
                heavyLifter = heavyLifter,
                onAchievementClick = {
                }
            )

        }


        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)

    }

}


@Composable
fun TopBarProfile(backClick: () -> Unit){
    Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier
        .height(56.dp)
        .fillMaxWidth()) {

        Row(modifier = Modifier.clickable{backClick()}){
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
                 heavyLifter: Boolean,
                 onAchievementClick:(AchievementInfo)->Unit
){
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
                                modifier=Modifier.weight(1f).clickable{onAchievementClick(
                                    AchievementInfo("Первая кровь", "Выполни первую тренировку", firstWorkout)) }) {
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
                                modifier=Modifier.weight(1f).clickable{onAchievementClick(
                                    AchievementInfo("Ты всё ещё здесь?","Выполни 3 тренировки",threeWorkout)) }) {
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
                                modifier=Modifier.weight(1f).clickable{onAchievementClick(
                                    AchievementInfo("Жаворонок","Потренируйся раньше 9 утра",earlyBird)
                                )}) {
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
                                modifier=Modifier.weight(1f).clickable{
                                    onAchievementClick(AchievementInfo
                                        ("Мешок картошки","Подними 100 кг",heavyLifter))
                                }) {
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
                                modifier=Modifier.weight(1f).clickable{onAchievementClick(
                                    AchievementInfo("Батя в зале","Сходи на 10 тренировок",tenWorkout)
                                )}) {
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



@Preview(showBackground = true,showSystemUi = true, device = Devices.PIXEL_6)
@Composable
fun ProfilePreviewSSSSS(){
    AndeGymTheme{
        FriendProfileScreen(
            uid="",
            homeClick = {},
            gymClick = {},
            friendsListClick = {},
            profileClick = {},
            backClick = {})
    }
}