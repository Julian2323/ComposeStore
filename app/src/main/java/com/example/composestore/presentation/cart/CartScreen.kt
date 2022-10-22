package com.example.composestore.presentation.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composestore.common.components.CustomScaffold

@Composable
fun CartScreen(
    navController: NavController
) {
    CustomScaffold(navController = navController) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "CARTSCREEN", color = Color.Black)
                Text(text = "FARTSCREEN", color = Color.Black)
            }
        }
    }
}