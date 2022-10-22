package com.example.composestore.presentation.favorites

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
fun FavoritesScreen(
    navController: NavController
) {
    CustomScaffold(navController = navController) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = "FAVSCREEN", color = Color.Black)
                Text(text = "STAVESCREEN", color = Color.Black)
            }
        }
    }
}