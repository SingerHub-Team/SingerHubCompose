package com.capstone.singerhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.capstone.singerhub.ui.onboard.Onboard
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.SolidCream
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class OnboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = SolidCream
            )
            SingerHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SolidCream
                ) {
                    Onboard().OnboardMain(LocalContext.current, this)
                }
            }
        }
    }
}