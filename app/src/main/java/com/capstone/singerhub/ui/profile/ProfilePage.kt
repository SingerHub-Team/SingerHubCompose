package com.capstone.singerhub.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Help
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.ProfBackground
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.WhiteNotWhite

class ProfilePage {
    private val dummySkills = listOf(
        "Singing", "Guitar", "Piano"
    )


    @Composable
    fun GetProfilePage() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(WhiteNotWhite)
        ) {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Card(
                        colors = CardDefaults.cardColors(containerColor = ProfBackground),
                        elevation = CardDefaults.cardElevation(0.dp),
                        shape = CircleShape,
                        modifier = Modifier
                            .padding(top = 24.dp)
                            .width(100.dp)
                            .height(100.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = "FM",
                                    fontSize = 24.sp,
                                    fontFamily = MontSerrat,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Fakhri Maulana Falah",
                        color = Color.Black,
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Lead Singer",
                        color = Color.Black,
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "fakhrimf23@gmail.com",
                        color = Color.Black.copy(0.4f),
                        fontFamily = MontSerrat,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 24.dp)
                    )
                }
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Work Experience",
                    color = Color.Black,
                    fontFamily = MontSerrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp)
                )
                Text(
                    text = "I have been a lead singer since 2020",
                    color = Color.Black.copy(0.4f),
                    fontFamily = MontSerrat,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, top = 5.dp)
                )
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "Skills",
                    color = Color.Black,
                    fontFamily = MontSerrat,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp)
                )
                LazyRow(
                    content = {
                        itemsIndexed(dummySkills) { _, item ->
                            Card(
                                colors = CardDefaults.cardColors(containerColor = Coral),
                                modifier = Modifier.padding(top = 11.dp, end = 11.dp)
                            ) {
                                Text(
                                    text = item,
                                    color = Color.White,
                                    fontFamily = MontSerrat,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
                                )
                            }
                        }
                    },
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Help,
                        contentDescription = "?",
                        tint = Coral,
                        modifier = Modifier
                            .width(32.dp)
                            .height(32.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Take a quiz to stand out from other candidates",
                        color = Color.Black.copy(0.4f),
                        fontFamily = MontSerrat,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(bottom = 16.dp, top = 16.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Take Quiz",
                        color = Color.Blue.copy(0.5f),
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .clickable {

                            }
                    )
                }
            }
        }
    }

    @Preview
    @Composable
    fun PreviewProfilePage() {
        SingerHubTheme {
            GetProfilePage()
        }
    }
}