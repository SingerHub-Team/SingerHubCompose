package com.capstone.singerhub.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.DarkBrown
import com.capstone.singerhub.ui.theme.Milo
import com.capstone.singerhub.ui.theme.MontSerrat

object Template {
    @Composable
    fun Title(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Bold,
            color = Coral,
            fontSize = 40.sp,
            lineHeight = 54.sp,
            modifier = modifier
        )
    }

    @Composable
    fun Subtitle(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Bold,
            color = Milo,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            modifier = modifier,
        )
    }

    @Composable
    fun InfoText(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Medium,
            color = Milo,
            fontSize = 14.sp,
            lineHeight = 24.sp,
            modifier = modifier,
        )
    }



    @Composable
    fun TextClick(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            fontFamily = MontSerrat,
            fontWeight = FontWeight.Bold,
            color = DarkBrown,
            fontSize = 14.sp,
            lineHeight = 24.sp,
            modifier = modifier,
        )
    }

    @Composable
    fun ButtonText(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            fontFamily = MontSerrat,
            color = Color.White,
            fontSize = 18.sp,
            lineHeight = 18.sp,
            modifier = modifier,
        )
    }
}