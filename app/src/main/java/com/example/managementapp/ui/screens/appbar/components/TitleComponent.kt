package com.example.managementapp.ui.screens.appbar.components

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.managementapp.R

@Composable
fun TitleComponent(@DrawableRes icon: Int) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = ""
    )
}