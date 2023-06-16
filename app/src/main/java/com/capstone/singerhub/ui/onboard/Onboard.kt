package com.capstone.singerhub.ui.onboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.capstone.singerhub.R
import com.capstone.singerhub.ui.login.LoginActivity
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.DarkBrown
import com.capstone.singerhub.ui.theme.Milo
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.SolidCream
import com.capstone.singerhub.utils.Template.ButtonText
import com.capstone.singerhub.utils.Template.Subtitle
import com.capstone.singerhub.utils.Template.Title

class Onboard {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OnboardMain(context: Context, activity: ComponentActivity) {
        Column(modifier = Modifier.height(300.dp).fillMaxWidth().offset(y = (-100).dp)){}
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = SolidCream),
                    title = {
                        Image(
                            painter = painterResource(id = R.drawable.singerhub),
                            contentDescription = stringResource(
                                id = R.string.app_name
                            ),
                            modifier = Modifier
                                .width(32.dp)
                                .height(32.dp)
                        )
                    },
                )
            },
            modifier = Modifier.statusBarsPadding(),
            contentWindowInsets = WindowInsets(top = 0.dp),
            content = {
                OnboardContent(Modifier.padding(it), context, activity)
            }
        )
    }

    @Composable
    fun OnboardContent(modifier: Modifier, context: Context, activity: ComponentActivity) {
        Column(
            modifier = modifier
                .background(SolidCream)
                .fillMaxHeight()
                .fillMaxWidth(),
        ) {
            Column(modifier = Modifier.padding(30.dp)) {
                Title(text = "Connecting\nSingers\nAll Around")
                Subtitle(
                    text = "Find your perfect talent.\nFind your perfect gig.",
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Row {
                Image(
                    painter = painterResource(id = R.drawable.onboard),
                    contentDescription = "onboard_image",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )
            }
            Column {
                Button(
                    onClick = {
                        activity.finish()
                        context.startActivity(Intent(context, LoginActivity::class.java))
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBrown),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(65.dp),
                    content = {
                        ButtonText(text = "Get Started")
                    })
            }
        }
    }

    @Preview
    @Composable
    fun PreviewTitle() {
        SingerHubTheme {
            Title(text = "SingerHub")
        }
    }

    @Preview
    @Composable
    fun PreviewSubtitle() {
        SingerHubTheme {
            Subtitle(text = "SingerHub")
        }
    }
}