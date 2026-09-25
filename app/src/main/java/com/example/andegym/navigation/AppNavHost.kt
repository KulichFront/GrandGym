package com.example.andegym.navigation

import android.R.attr.type
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.NavType.Companion.StringType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.andegym.Onboarding
import com.example.andegym.ui.auth.LoginScreen
import com.example.andegym.ui.dashboard.HomeScreen
import com.example.andegym.ui.friends.FriendProfileScreen
import com.example.andegym.ui.friends.FriendsListScreen
import com.example.andegym.ui.profile.ProfileScreen
import com.example.andegym.ui.requests.requestsScreen
import com.example.andegym.ui.trainig.TrainingScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AppNavHost(
    navHostController: NavHostController,

){
    NavHost(
        navController = navHostController,
        startDestination = Destination.Auth.route,
    ){

        composable(route= Destination.Auth.route){
            LoginScreen( onAuthSuccess = {
                navHostController.navigate(Destination.Start.route)
            })
        }

        composable (route= Destination.Start.route){
            Onboarding(onNextClick={
                navHostController.navigate(Destination.Home.route)
            })

        }
        composable(route=Destination.Home.route){
            HomeScreen(
                startGymClick = {navHostController.navigate(Destination.Gym.route)},
                homeClick = {navHostController.navigate(Destination.Home.route)},
                gymClick = {navHostController.navigate(Destination.Gym.route)},
                friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                profileClick ={navHostController.navigate(Destination.Me.route)}
                )
        }
        composable(route=Destination.Gym.route){
            TrainingScreen (

                homeClick = {navHostController.navigate(Destination.Home.route)},
                gymClick = {navHostController.navigate(Destination.Gym.route)},
                friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                profileClick ={navHostController.navigate(Destination.Me.route)}
            )
        }
        composable(route=Destination.Friends.route){
            FriendsListScreen (

                homeClick = {navHostController.navigate(Destination.Home.route)},
                gymClick = {navHostController.navigate(Destination.Gym.route)},
                friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                profileClick ={navHostController.navigate(Destination.Me.route)},
                onListRequestCLick={navHostController.navigate(Destination.Request.route)},
                onFriendCLick={ uid ->
                    navHostController.navigate(Destination.Friend.createRoute(uid))
                }
            )
        }
        composable(route=Destination.Me.route){
            ProfileScreen(

                 homeClick = {navHostController.navigate(Destination.Home.route)},
                 gymClick = {navHostController.navigate(Destination.Gym.route)},
                 friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                 profileClick ={navHostController.navigate(Destination.Me.route)},
                onLogout = {

                    FirebaseAuth.getInstance().signOut()
                    navHostController.navigate(Destination.Auth.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
             )
        }

        composable(route=Destination.Request.route){
            requestsScreen (

                homeClick = {navHostController.navigate(Destination.Home.route)},
                gymClick = {navHostController.navigate(Destination.Gym.route)},
                friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                profileClick ={navHostController.navigate(Destination.Me.route)},
                onBackClick={navHostController.popBackStack()}
            )
        }

        composable (
            route="friend/{uid}",
            arguments = listOf(navArgument("uid"){type= StringType }),

        ){
            backStackEntry->
            val uid=backStackEntry.arguments?.getString("uid")?:""
            FriendProfileScreen(
                uid=uid,
                homeClick = {navHostController.navigate(Destination.Home.route)},
                gymClick = {navHostController.navigate(Destination.Gym.route)},
                friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                profileClick ={navHostController.navigate(Destination.Me.route)},
                backClick = {navHostController.popBackStack()}
            )
        }
    }
}