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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.andegym.R
import com.example.andegym.data.model.User
import com.example.andegym.ui.components.BottomNavigation
import com.example.andegym.ui.theme.AndeGymTheme
import com.example.andegym.viewmodel.FriendsViewModel

@Composable
fun FriendsListScreen(
    viewModel: FriendsViewModel= viewModel(),
    homeClick:()->Unit,
    gymClick:()->Unit,
    friendsListClick:()->Unit,
    profileClick:()->Unit,
){
    val searchText by viewModel.searchText.collectAsState()
    val searchResult by viewModel.searchResult.collectAsState()
    val searchError by viewModel.searchError.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val friends by viewModel.friends.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.loadFriends()
    }

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
            SearchFriend(
                searchText=searchText,
                onSearchTextChange = {it -> viewModel.updateSearchText(it)},
                onSearchClick = {viewModel.searchUser()})
            if(isLoading){
                Text(
                    text="Ищем друга",
                    fontSize = 24.sp,

                )
            }
            else if(searchResult!=null){
               searchResultCard(
                   user=searchResult!!,
                   onAddClick =
                       {
                           viewModel.addFriend(searchResult!!.userId)
                           viewModel.clearSearch()}
               )

            }
            else if(searchError!=null){
                Text(
                    text = searchError!!,
                    color = Color(0xFFFF6B6B),
                    fontSize = 14.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
            FriendsList(friends)
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
fun SearchFriend(
    searchText:String,
    onSearchTextChange:(String)->Unit,
    onSearchClick:()->Unit
){

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
            onValueChange = onSearchTextChange,
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
        Button(onClick = onSearchClick, modifier = Modifier.weight(1f)){
            Text("Найти")
        }
    }
}

@Composable
fun FriendsList(friends:List<User>) {
    if (friends.isEmpty()) {
        Text(
            text = "У тебя пока что нет друзей",
            fontSize = 20.sp
        )
    } else {
        LazyColumn() {
            items(friends) { friend ->
                friendCard(friend)
            }
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
                contentDescription = "RequestToMe",
                modifier=Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text="Запросы в друзья",
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
