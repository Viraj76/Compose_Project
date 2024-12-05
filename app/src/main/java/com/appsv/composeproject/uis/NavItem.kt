package com.appsv.composeproject.uis


import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavIcon {
    data class Vector(val imageVector: ImageVector) : NavIcon()
    data class Resource(val resId: Int) : NavIcon()
}

data class NavItem(
    val label: String,
    val icon: NavIcon
)
