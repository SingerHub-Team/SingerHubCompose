package com.capstone.singerhub.ui.home

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.capstone.singerhub.R
import com.capstone.singerhub.models.officeTemplateGenerator
import com.capstone.singerhub.models.postTemplateGenerator
import com.capstone.singerhub.ui.item.ItemHome
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.DarkItem
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.SolidCream
import com.capstone.singerhub.ui.theme.WhiteNotWhite
import com.capstone.singerhub.utils.BottomNavItem
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
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
                    color = WhiteNotWhite
                )
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent
                    )
                    systemUiController.setStatusBarColor(
                        color = WhiteNotWhite
                    )
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SolidCream
                ) {
                    MainScreen(context = LocalContext.current)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(context: Context, modifier: Modifier = Modifier) {
//    Template
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 10.dp)
            .background(Color(0xFFF2F2F2))
    ) {
        val offices = officeTemplateGenerator(10)
        items(postTemplateGenerator(10).toList(), key = { it.id }) {
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            ItemHome().ItemJob(
                context = context,
                postModel = it,
                officeModel = offices[it.officeId]
            )
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: Context) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNav(navController = navController)
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxHeight()
        ) {
            MainNavGraph(
                navHostController = navController,
                context = context,
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Composable
fun MainNavGraph(
    navHostController: NavHostController,
    context: Context,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
            .background(
                WhiteNotWhite
            )
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen(context = context)
        }
        composable(BottomNavItem.Search.route) {
            HomeScreen(context = context)
        }
        composable(BottomNavItem.Notification.route) {
            HomeScreen(context = context)
        }
        composable(BottomNavItem.Profile.route) {
            HomeScreen(context = context)
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = WhiteNotWhite,
        elevation = 0.dp,
        modifier = Modifier.statusBarsPadding(),
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
            Text(
                text = "Recommended Gigs",
                fontFamily = MontSerrat,
                fontWeight = FontWeight.Bold,
                color = Coral,
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 12.dp)
            )
        },
    )
}

@Composable
fun BottomNav(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Notification,
        BottomNavItem.Profile
    )
    NavigationBar(
        contentColor = DarkItem,
        containerColor = SolidCream
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach {
            NavigationBarItem(
                icon = {
                    Icon(imageVector = it.icon, contentDescription = it.title)
                },
                label = {
                    Text(text = it.title, fontSize = 12.sp)
                },
                selected = currentRoute == it.route,
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = DarkItem,
                    selectedIconColor = DarkItem,
                    indicatorColor = Coral,
                    unselectedIconColor = DarkItem.copy(0.4f),
                    unselectedTextColor = DarkItem.copy(0.4f)
                ),
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    SingerHubTheme {
        TopBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    SingerHubTheme {
        MainScreen(context = LocalContext.current)
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    SingerHubTheme {
        HomeScreen(context = LocalContext.current)
    }
}