package com.example.andegym.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.andegym.FriendsListScreen
import com.example.andegym.HomeScreen
import com.example.andegym.Onboarding
import com.example.andegym.ProfileScreen
import com.example.andegym.TrainingScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController,

){
    NavHost(
        navController = navHostController,
        startDestination = Destination.Start.route,
    ){


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
                profileClick ={navHostController.navigate(Destination.Me.route)}
            )
        }
        composable(route=Destination.Me.route){
            ProfileScreen(

                 homeClick = {navHostController.navigate(Destination.Home.route)},
                 gymClick = {navHostController.navigate(Destination.Gym.route)},
                 friendsListClick = {navHostController.navigate(Destination.Friends.route)},
                 profileClick ={navHostController.navigate(Destination.Me.route)}
             )
        }

    }
}