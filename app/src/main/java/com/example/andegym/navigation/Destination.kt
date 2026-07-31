package com.example.andegym.navigation

sealed class Destination (val route: String){


    data object  Home: Destination(ROUTE_HOME)
    data object  Gym: Destination(ROUTE_GYM)
    data object  Friends: Destination(ROUTE_FRIENDS)
    data object  Me: Destination(ROUTE_ME)
    data object  Start: Destination(ROUTE_START)

    companion object{
        private const val ROUTE_HOME="route_home"
        private const val ROUTE_GYM="route_gym"
        private const val ROUTE_FRIENDS="route_friends"
        private const val ROUTE_ME="route_me"

        private  const val  ROUTE_START="route_start"
    }
}