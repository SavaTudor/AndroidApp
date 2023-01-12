package com.example.myapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.myapp.component.CustomTopAppBar
import com.example.myapp.domain.User

@Composable
fun MainList(navController: NavHostController, users: List<User>) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBarList(navController, users)
    }
}

@Composable
fun ScaffoldWithTopBarList(navController: NavHostController, users: List<User>) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "My Contacts", false)
        },
        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                users.forEach { user ->
                    UserRow(User(user.id, user.first_name, user.first_name, user.email))
                }
            }
        }
    )
}

@Composable
fun UserRow(user: User) {
    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Row() {
                Text(
                    user.first_name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(10.dp),
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    user.last_name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(10.dp),
                    fontFamily = FontFamily.Monospace
                )
            }
            Text(
                user.email,
                fontSize = 25.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(10.dp),
                fontFamily = FontFamily.Monospace
            )
        }
    }
}