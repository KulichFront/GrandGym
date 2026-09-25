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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices.PIXEL_6
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.R
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.viewmodel.FriendsViewModel


@Composable
fun requestsScreen(
        viewModel: FriendsViewModel=viewModel() ,
        homeClick:()->Unit,
        gymClick:()->Unit,
        friendsListClick:()->Unit,
        profileClick:()->Unit,
        onBackClick: () -> Unit) {
    val requestFlow by viewModel.requestsFlow.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadRequest()
    }
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

        ) {
            TopBarRequest(onBackClick)
            if(requestFlow.isEmpty()){
                Text(
                    text="У тебя нет входящих запросов",
                    fontSize = 16.sp,
                    color = Color(0xFFA0A0A0),
                    modifier=Modifier.padding(16.dp)
                )
            }
            else{
                LazyColumn() {
                    items(requestFlow){
                        request -> requestCard(
                        user=request,
                        onAccept = {viewModel.acceptRequest(request.userId)},
                        onDecline = {viewModel.declineRequest(request.userId)})
                    }
                }
            }
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