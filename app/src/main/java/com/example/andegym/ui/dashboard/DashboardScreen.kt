package com.example.andegym.ui.dashboard

import CardGym
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.R
import com.example.andegym.data.model.ExercisePlan
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.viewmodel.DashboardViewModel



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
fun Exercises( plan:List<ExercisePlan>){
    Text(
        text="План на сегодня",
        fontSize = 14.sp,
        fontFamily=FontFamily(Font(R.font.manrope_semibold)),
        color=Color(0xFFA0A0A0),
        modifier=Modifier.padding(top=24.dp,start=16.dp)
    )
    Spacer(Modifier.height(12.dp))
    if(plan.isNotEmpty()){
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start=16.dp)
        )
        {

            items(plan) { gym ->
                CardGym(gym)
            }
        }
    }
    else{
        Text(
            text="Отдыхай, ты хорошо поработал",
            fontSize = 14.sp,
            fontFamily=FontFamily(Font(R.font.manrope_semibold)),
            color=Color(0xFFA0A0A0),
            modifier=Modifier.padding(top=24.dp,start=16.dp)
        )
    }


    }






@Composable
fun HomeScreen(viewModel: DashboardViewModel = viewModel(),
               startGymClick:()->Unit,
               homeClick:()->Unit,
               gymClick:()->Unit,
               friendsListClick:()->Unit,
               profileClick:()->Unit,
) {
    val plan by viewModel.todayPlan.collectAsState()
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
            Exercises(plan)
        }

        BottomNavigation(homeClick,gymClick,friendsListClick,profileClick)
    }
}
