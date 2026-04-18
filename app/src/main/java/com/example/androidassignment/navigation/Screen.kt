package com.example.androidassignment.navigation

sealed class Screen(val route:String){
    object Home:Screen("home")
    object Detail:Screen("detail/{movieId}"){
        fun createRoute(movieId:String)="detail/$movieId"
    }
}