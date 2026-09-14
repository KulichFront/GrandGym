package com.example.andegym.ui.trainig

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.App

import com.example.andegym.R

import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.viewmodel.TrainingViewModel

@Composable
fun TrainingScreen(viewModel: TrainingViewModel=viewModel(),
    homeClick:()->Unit,
    gymClick:()->Unit,
    friendsListClick:()->Unit,
    profileClick:()->Unit,
){
    val isRunning by viewModel.isRunning.collectAsState()
    val timer by viewModel.time.collectAsState()
    val weight by viewModel.weight.collectAsState()
    val app = LocalContext.current.applicationContext as App
    val repository=app.repository
    val currentExercise by viewModel.currentExercise.collectAsState()
    val isWorkoutFinished by viewModel.isWorkoutFinished.collectAsState()
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
            if(!isWorkoutFinished){
                TimerRest(timer=timer)
                CardGym(weight=weight,
                    increaseWeight = {viewModel.increaseWeight()},
                    decreaseWeight = {viewModel.decreaseWeight()},
                    exercise = currentExercise)
                ButtonGym(isRunning=isRunning,
                    onPauseClick = {viewModel.pauseRest()},
                    onResumeClick = { viewModel.resumeRest()},
                    onFinishClick = {viewModel.finishCurrentExercise()})
            }
            else{
                Text(
                    text="ТРЕНИРОВКА ЗАВЕРШЕНА",
                    fontFamily = FontFamily(Font(R.font.jura_bold)),
                    fontSize = 40.sp,
                    color=Color(0xFFE0E0E0),
                    textAlign = TextAlign.Center
                    )
            }
        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
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
fun ButtonGym(isRunning: Boolean,
              onPauseClick: () -> Unit,
              onResumeClick: () -> Unit,
              onFinishClick: () -> Unit){
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),modifier=Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
    ){ if(isRunning){
        Button(onClick = onPauseClick, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),shape=RoundedCornerShape(16.dp), modifier = Modifier
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
                    fontSize = 12.sp,
                    color=Color(0xFFE0E0E0)
                )
            }
        }
    }else{
        Button(onClick = onResumeClick, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3A3A3A)),shape=RoundedCornerShape(16.dp), modifier = Modifier
            .height(48.dp)
            .weight(1f))
        {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    tint=Color(0xFFE0E0E0),
                    contentDescription = "CONTINUE",
                    modifier= Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text="ПРОДОЛЖИТЬ",
                    fontFamily = FontFamily(Font(R.font.manrope_semibold)),
                    fontSize = 12.sp,
                    color=Color(0xFFE0E0E0)
                )
            }
        }
    }

        Button(onClick = onFinishClick, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B6B)),shape=RoundedCornerShape(16.dp), modifier = Modifier
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
                    fontSize = 12.sp,
                    color=Color.White
                )
            }
        }
    }
}

