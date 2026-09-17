package com.example.andegym.ui.requests

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices.PIXEL_6
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.andegym.R
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.dashboard.Exercises
import com.example.andegym.ui.dashboard.Hello
import com.example.andegym.ui.dashboard.HowReady
import com.example.andegym.ui.dashboard.StartGym
import com.example.andegym.ui.dashboard.TopBarHome

@Composable
fun requestsScreen(homeClick:()->Unit,
                   gymClick:()->Unit,
                   friendsListClick:()->Unit,
                   profileClick:()->Unit,
                   onBackClick: () -> Unit) {
    Column(
        modifier = Modifier

            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
            .statusBarsPadding()
            .navigationBarsPadding()

    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            TopBarRequest(onBackClick)
        }

        BottomNavigation(homeClick, gymClick, friendsListClick, profileClick)
    }
}



@Composable
fun TopBarRequest(onBackClick:()->Unit){
    Row(verticalAlignment = Alignment.CenterVertically,modifier=Modifier
        .height(56.dp)
        .fillMaxWidth()) {
        Row(modifier = Modifier.clickable{onBackClick()}){Icon(
            imageVector = Icons.Default.ArrowBack,
            tint = Color(0xFFE0E0E0),
            contentDescription = "Back",
            modifier = Modifier
                .size(40.dp)
                .padding(start = 16.dp)
        )
            Spacer(Modifier.width(12.dp))
            Text(
                text="ЗАПРОСЫ В ДРУЗЬЯ",
                fontFamily = FontFamily(Font(R.font.jura_bold)),
                fontSize = 18.sp,
                color=Color(0xFFE0E0E0),

                )}


    }

}








@Preview(showSystemUi = true, showBackground = true, device = PIXEL_6)
@Composable
fun requestsPreview(){
    requestsScreen(homeClick = {},
        gymClick = {},
        friendsListClick = {},
        profileClick = {},
        onBackClick = {})
}