package ru.robbo.robbohub.ui.components.bottomNavigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name : String,
    val route: String,
    @StringRes val topBarStringId: Int,
    val icon: ImageVector
)