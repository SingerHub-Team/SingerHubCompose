package com.capstone.singerhub.ui.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.WhiteNotWhite

class NotificationPage {
    @Composable
    fun GetNotificationPage() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteNotWhite),
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "No notifications yet...",
                    color = Coral,
                    fontFamily = MontSerrat,
                    fontWeight = FontWeight.Medium,
                )
            }
        }
    }
}