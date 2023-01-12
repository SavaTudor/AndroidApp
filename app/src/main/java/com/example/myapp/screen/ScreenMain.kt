package com.example.myapp.screen

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.Routes
import com.example.myapp.domain.User
import okhttp3.Route

@Composable
fun ScreenMain(){
    val navController = rememberNavController()
    val users = listOf(
        User(1L, "Test", "Mock", "email"),
        User(2L, "Test1", "Mock1", "email1"),
        User(3L, "Test2", "Mock2", "email2"),
        User(4L, "Test3", "Mock3", "email3"),
        User(5L, "Test4", "Mock4", "email4"),
        User(6L, "Test5", "Mock5", "email5"),
        User(7L, "Test6", "Mock6", "email6"),
    )
    NavHost(navController = navController, startDestination = Routes.Login.route) {

        composable(Routes.Login.route) {
            LoginPage(navController = navController)
        }

        composable(Routes.SignUp.route) {
            SignUp(navController = navController)
        }

        composable(Routes.ForgotPassword.route) { navBackStack ->
            ForgotPassword(navController = navController)
        }

        composable(Routes.MainList.route){
            MainList(navController = navController, users = users)
        }
    }
}