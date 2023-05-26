package com.capstone.singerhub.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.capstone.singerhub.R
import com.capstone.singerhub.ui.home.MainActivity
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.DarkBrown
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.SolidCream
import com.capstone.singerhub.utils.Template
import com.capstone.singerhub.utils.Template.InfoText
import com.capstone.singerhub.utils.Template.TextClick
import com.capstone.singerhub.utils.Template.Title
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SingerHubTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent
                )
                systemUiController.setStatusBarColor(
                    color = Color.Transparent
                )
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent
                    )
                    systemUiController.setStatusBarColor(
                        color = Color.Transparent
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SolidCream
                ) {
                    LoginMain()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginMain() {
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
            LoginContent(modifier = Modifier.padding(it), LocalContext.current)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(modifier: Modifier, context: Context) {
    var loginInput by rememberSaveable {
        mutableStateOf("")
    }
    var passwordInput by rememberSaveable {
        mutableStateOf("")
    }
    var isPasswordVisible by rememberSaveable {
        mutableStateOf(false)
    }
    val textFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.White,
        textColor = Color.Black,
        disabledIndicatorColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedLeadingIconColor = Coral,
        focusedTrailingIconColor = Coral,
        focusedLabelColor = Coral,
        unfocusedTrailingIconColor = Color.Black,
        unfocusedLeadingIconColor = Color.Black,
        unfocusedLabelColor = Color.Black
    )
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .background(SolidCream)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.pattern),
                contentDescription = "background_pattern",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .offset(y = 25.dp),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(20.dp),
//            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Title("Login to\nSingerHub", modifier = Modifier.padding(top = 150.dp))
            Column(modifier = Modifier.padding(top = 50.dp)) {

                // E-Mail TextField
                TextField(
                    value = loginInput,
                    onValueChange = { loginInput = it },
                    label = { Text(text = "E-Mail") },
                    leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "email_icon") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    textStyle = TextStyle(
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(CircleShape),
                    colors = textFieldColors
                )

                // Password Field
                TextField(
                    value = passwordInput,
                    onValueChange = { passwordInput = it },
                    label = { Text(text = "Password") },
                    leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "email_icon") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    textStyle = TextStyle(
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp
                    ),
                    trailingIcon = {
                        val image =
                            if (isPasswordVisible) Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff
                        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                            Icon(imageVector = image, contentDescription = null)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .clip(CircleShape),
                    colors = textFieldColors
                )

                Button(
                    onClick = {
                        context.startActivity(Intent(context, MainActivity::class.java))
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBrown),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp, bottom = 10.dp)
                        .height(65.dp),
                    content = {
                        Template.ButtonText(text = "Login")
                    })

                Row(modifier = Modifier.padding(vertical = 10.dp)) {
                    InfoText(text = "No Account?")
                    TextClick(text = "Register Here",
                        Modifier
                            .padding(start = 10.dp)
                            .clickable {

                            })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    SingerHubTheme {
        LoginMain()
    }
}