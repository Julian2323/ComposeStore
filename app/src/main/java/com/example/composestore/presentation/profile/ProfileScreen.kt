package com.example.composestore.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composestore.common.components.CustomScaffold
import com.example.composestore.presentation.Screen
import com.example.composestore.presentation.auth.login.AuthViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel()
) {
    CustomScaffold(navController = navController) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Text(text = "PROFILESCREEN", color = Color.Black)
                Button(onClick = {
                    viewModel.logout()
                    navController.navigate(Screen.LoginScreen.route)
                }) {
                    Text(text = "Sign Out", color = MaterialTheme.colors.secondary)

                }
            }
        }
    }

}