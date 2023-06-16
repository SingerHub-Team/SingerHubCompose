package com.capstone.singerhub.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.capstone.singerhub.R
import com.capstone.singerhub.models.OfficeModel
import com.capstone.singerhub.models.PostModel
import com.capstone.singerhub.models.officeTemplate
import com.capstone.singerhub.models.postTemplate
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.ui.theme.WhiteNotWhite
import com.capstone.singerhub.utils.Constants.OFFICE_DETAIL
import com.capstone.singerhub.utils.Constants.POST_DETAIL
import java.text.DecimalFormat

class DetailPositionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val model = intent.getParcelableExtra<PostModel>(POST_DETAIL)
        val officeModel = intent.getParcelableExtra<OfficeModel>(OFFICE_DETAIL)
        setContent {
            SingerHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailPage(
                        model = model!!,
                        context = LocalContext.current,
                        officeModel = officeModel!!
                    )
                }
            }
        }
    }
}

@Composable
fun DetailPage(model: PostModel, context: Context, officeModel: OfficeModel) {
    val formatter = DecimalFormat("#,###")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteNotWhite)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .data(model.backgroundImage)
                    .crossfade(true)
                    .build(),
                contentDescription = model.position,
                placeholder = painterResource(id = R.drawable.urban_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
            )
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.height(130.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(officeModel.officeIcon)
                            .crossfade(true)
                            .build(),
                        contentDescription = officeModel.name,
                        placeholder = painterResource(id = R.drawable.shop_placeholder),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 5.dp)
                            .height(75.dp)
                            .width(75.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextTitleItem(
                    text = model.position,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                )
            }
            TextSubtitleItem(
                text = officeModel.name,
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp)
                    .offset(y = (-10).dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.Start,
            ) {
                Icon(
                    imageVector = Icons.Filled.Verified,
                    contentDescription = "Verified Place",
                    modifier = Modifier
                        .width(16.dp)
                        .height(16.dp),
                    tint = Coral
                )
                TextInfoItem(
                    text = officeModel.place, modifier = Modifier
                        .padding(start = 5.dp)
                        .offset(y = (-0.5).dp)
                )
            }
            TextInfoItem(
                text = "IDR ${formatter.format(model.salaryStart)} - ${
                    formatter.format(
                        model.salaryEnd
                    )
                } / ${model.salaryPer}",
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            )
        }
        Text(
            text = model.desc,
            fontFamily = MontSerrat,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
            color = Color.Black
        )
    }
}

@Composable
fun TextTitleItem(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.Black,
        fontSize = 18.sp,
        fontFamily = MontSerrat,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun TextSubtitleItem(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.Gray,
        fontSize = 12.sp,
        fontFamily = MontSerrat,
    )
}

@Composable
fun TextInfoItem(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = Color.Black,
        fontSize = 12.sp,
        fontFamily = MontSerrat,
        fontWeight = FontWeight.SemiBold
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    SingerHubTheme {
        DetailPage(postTemplate, LocalContext.current, officeTemplate)
    }
}