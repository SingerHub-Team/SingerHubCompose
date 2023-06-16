package com.capstone.singerhub.ui.item

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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
import com.capstone.singerhub.ui.detail.DetailPositionActivity
import com.capstone.singerhub.ui.theme.Coral
import com.capstone.singerhub.ui.theme.MontSerrat
import com.capstone.singerhub.ui.theme.SingerHubTheme
import com.capstone.singerhub.utils.Constants.OFFICE_DETAIL
import com.capstone.singerhub.utils.Constants.POST_DETAIL
import java.text.DecimalFormat

class ItemHome {
    @Composable
    fun ItemJob(
        context: Context,
        modifier: Modifier = Modifier,
        postModel: PostModel,
        officeModel: OfficeModel
    ) {

        var isBookmarked by rememberSaveable {
            mutableStateOf(false)
        }

        val formatter = DecimalFormat("#,###")

        Card(
            modifier = modifier
                .fillMaxWidth()
                .height(230.dp)
                .clickable {
                    val intent = Intent(context, DetailPositionActivity::class.java)
                    intent.putExtra(POST_DETAIL, postModel)
                    intent.putExtra(OFFICE_DETAIL, officeModel)
                    context.startActivity(intent)
                }
                .padding(vertical = 5.dp, horizontal = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Box {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(postModel.backgroundImage)
                        .crossfade(true)
                        .build(),
                    contentDescription = postModel.position,
                    placeholder = painterResource(id = R.drawable.urban_background),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(90.dp), horizontalArrangement = Arrangement.End
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
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextTitleItem(
                        text = postModel.position,
                        modifier = Modifier.padding(top = 10.dp, start = 10.dp)
                    )
                    IconButton(
                        onClick = {
                            isBookmarked = !isBookmarked
                        }) {
                        val image =
                            if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder
                        Icon(
                            imageVector = image,
                            contentDescription = "Bookmark",
                            modifier = Modifier
                                .width(32.dp)
                                .height(32.dp),
                            tint = if (isBookmarked) Coral else Color.DarkGray
                        )
                    }
                }
                TextSubtitleItem(
                    text = officeModel.name,
                    modifier = Modifier
                        .padding(start = 10.dp)
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
                    text = "IDR ${formatter.format(postModel.salaryStart)} - ${
                        formatter.format(
                            postModel.salaryEnd
                        )
                    } / ${postModel.salaryPer}",
                    modifier = Modifier.padding(start = 10.dp, top = 5.dp)
                )
                TextPostedItem(
                    text = "Posted ${postModel.posted}",
                    modifier = Modifier.padding(start = 10.dp, top = 2.dp)
                )
            }
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

    @Composable
    fun TextPostedItem(text: String, modifier: Modifier = Modifier) {
        Text(
            text = text,
            modifier = modifier.alpha(0.5.toFloat()),
            color = Color.Gray,
            fontSize = 12.sp,
            fontFamily = MontSerrat,
            fontWeight = FontWeight.SemiBold
        )
    }

    @Preview
    @Composable
    fun PreviewItemJob() {
        SingerHubTheme {
            ItemJob(
                modifier = Modifier,
                context = LocalContext.current,
                postModel = postTemplate,
                officeModel = officeTemplate,
            )
        }
    }
}