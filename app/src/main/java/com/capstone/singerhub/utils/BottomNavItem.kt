package com.capstone.singerhub.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val title: String, val icon: ImageVector, val route: String) {
    object Home : BottomNavItem("Home", Icons.Filled.Home, "home")
    object Search : BottomNavItem("Search", Icons.Filled.Search, "search")
    object Notification : BottomNavItem("Notification", Icons.Filled.Notifications, "notification")
    object Profile : BottomNavItem("Profile", Icons.Filled.Person, "profile")
}