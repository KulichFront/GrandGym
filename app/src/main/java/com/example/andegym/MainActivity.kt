package com.example.andegym

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.andegym.navigation.AppNavHost
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.dashboard.HomeScreen
import com.example.andegym.ui.friends.FriendsListScreen
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
