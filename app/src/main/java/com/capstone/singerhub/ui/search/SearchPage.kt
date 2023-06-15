package com.capstone.singerhub.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.capstone.singerhub.ui.theme.DarkBrown
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.SolidCream
import com.capstone.singerhub.ui.theme.WhiteNotWhite

class SearchPage {
    private val dummySearchRecs = listOf(
        "Guitarist",
        "Singer",
        "Pianist",
        "Drummer",
        "Keyboard",
        "DJ",
        "Backing Singer",
        "Bassist",
        "Sax",
        "Synth",
        "Rapper",
        "Sound Engineer",
        "Promoter",
        "Violinist",
        "Percussion"
    )


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun GetSearchPage(modifier: Modifier = Modifier) {
        var searchInput by remember {
            mutableStateOf(TextFieldValue(""))
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(WhiteNotWhite)
        ) {
            val textFieldColors = TextFieldDefaults.textFieldColors(
                containerColor = SolidCream.copy(0.4f),
                textColor = DarkBrown,
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLeadingIconColor = SolidCream,
                focusedTrailingIconColor = SolidCream,
                focusedLabelColor = SolidCream,
                unfocusedTrailingIconColor = DarkBrown,
                unfocusedLeadingIconColor = DarkBrown,
                unfocusedLabelColor = DarkBrown
            )
            TextField(
                value = searchInput,
                onValueChange = { searchInput = it },
                label = {
                    Text(
                        text = "Job title, keywords, or gigs",
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.Medium
                    )
                },
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "search_icon") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                textStyle = TextStyle(
                    fontFamily = MontSerrat,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
                    .height(60.dp)
                    .clip(CircleShape),
                colors = textFieldColors,
            )
            Text(
                text = "Roles",
                fontFamily = MontSerrat,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(20.dp),
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(top = 5.dp))
            LazyColumn(content = {
                itemsIndexed(dummySearchRecs) { _, item ->
                    Text(
                        text = item,
                        fontFamily = MontSerrat,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            }
                            .padding(vertical = 10.dp),
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(DarkBrown.copy(0.1f))
                    )
                }
            }, modifier = Modifier.padding(horizontal = 20.dp))
        }
    }

    @Preview
    @Composable
    fun PreviewSearch() {
        SingerHubTheme {
            GetSearchPage()
        }
    }
}