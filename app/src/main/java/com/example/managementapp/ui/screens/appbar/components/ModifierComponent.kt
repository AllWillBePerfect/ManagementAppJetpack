package com.example.managementapp.ui.screens.appbar.components

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import com.example.managementapp.ui.theme.topAppBarGradientBottom
import com.example.managementapp.ui.theme.topAppBarGradientTop

@Composable
fun modifierComponent(): Modifier {
    return Modifier
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(topAppBarGradientTop, topAppBarGradientBottom),
            )
        )
}