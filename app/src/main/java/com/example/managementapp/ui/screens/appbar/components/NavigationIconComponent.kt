package com.example.managementapp.ui.screens.appbar.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.managementapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NavigationIconComponent(scaffoldState: ScaffoldState, scopeState: CoroutineScope) {
    IconButton(onClick = {
        scopeState.launch {
            scaffoldState.drawerState.open()
        }
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = ""
        )
    }
}