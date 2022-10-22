package com.example.composestore.common.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun CustomScaffold(
    navController: NavController,
    items: List<BottomNavItem> = listOf(
        BottomNavItem.Home,
        BottomNavItem.Favorite,
        BottomNavItem.Cart,
        BottomNavItem.Profile,
    ),
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    elevation = 5.dp
                ) {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination
                    items.forEach { item ->
                        BottomNavigationItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = item.icon),
                                    contentDescription = null
                                )
                            },
                            selectedContentColor = MaterialTheme.colors.secondary,
                            unselectedContentColor = MaterialTheme.colors.secondary,
                            selected = currentDestination?.route?.contains(item.route) == true,
                            onClick = {
                                navController.navigate(item.route) /*{
                                    navController.graph.startDestinationRoute?.let { screen_route ->
                                        popUpTo(screen_route) {
                                            saveState = true
                                        }
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }*/
                            }
                        )
                    }
                }

        }
    ) { paddingValues ->
        content(paddingValues)
    }
}


