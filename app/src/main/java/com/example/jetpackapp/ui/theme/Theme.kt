package com.example.jetpackapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Definir el esquema de colores oscuro
private val DarkColorScheme = darkColorScheme(
    primary = Purple,
    secondary = OrangeAccent,
    background = RedBackground,
    surface = Purple,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

// Definir el esquema de colores claro
private val LightColorScheme = lightColorScheme(
    primary = Purple,
    secondary = OrangeAccent,
    background = RedBackground,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Purple,
    onBackground = GrayText,
    onSurface = GrayText
)

@Composable
fun JetpackAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
