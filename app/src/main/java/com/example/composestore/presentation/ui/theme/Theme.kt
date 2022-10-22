package com.example.composestore.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = myBlue,
    primaryVariant = myDarkBlue,
    secondary = myGold,
    background = myWhite,
    surface = myGray,
    onPrimary = myWhite,
    onSecondary = myWhite,
    onBackground = myWhite,
    onSurface = myWhite,
)

private val LightColorPalette = lightColors(
    primary = myBlue,
    primaryVariant = myDarkBlue,
    secondary = myGold,
    background = myWhite,
    surface = myGray,
    onPrimary = myWhite,
    onSecondary = myWhite,
    onBackground = myWhite,
    onSurface = myWhite,

)

@Composable
fun ComposeStoreTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}