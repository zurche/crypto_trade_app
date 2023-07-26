package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.az.cryptotradeapp.R
import com.az.cryptotradeapp.ui.theme.CryptoOrange

data class HomeHeaderUIData(
    val profilePictureURL: String,
    val hasNotifications: Boolean,
    val tradeValue: Float,
    val tradeValueCurrency: String
)

private val mockHomeHeaderUIData = HomeHeaderUIData(
    "https://firebasestorage.googleapis.com/v0/b/wall-mind.appspot.com/o/thumbnails%2Fabstract_14.jpg?alt=media&token=11ea8d06-2f60-43cc-85f4-ade552632078",
    true,
    980.60f,
    "USD"
)

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAHomeHeader(
    modifier: Modifier = Modifier,
    homeHeaderUIData: HomeHeaderUIData = mockHomeHeaderUIData
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            AsyncImage(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                model = homeHeaderUIData.profilePictureURL,
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop
            )

            CTANotificationsIcon(homeHeaderUIData.hasNotifications)

        }

        CTATodayValue(homeHeaderUIData.tradeValue, homeHeaderUIData.tradeValueCurrency)
    }
}

@Composable
@Preview(showBackground = true)
private fun CTATodayValue(tradeValue: Float = 980.60f, tradeValueCurrency: String = "USD") {
    Row(
        modifier = Modifier
            .padding(start = 35.dp, end = 35.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Today's", fontWeight = FontWeight.Bold)
            Text(text = "Trade Value")
        }

        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = "+$tradeValue",
                color = CryptoOrange,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                modifier = Modifier.padding(start = 5.dp, bottom = 3.dp),
                text = tradeValueCurrency,
                color = CryptoOrange,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun CTANotificationsIcon(hasNotifications: Boolean = true) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(30.dp)
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(rotationZ = 30f),
            painter = painterResource(id = R.drawable.bell_outline),
            contentDescription = "Notifications Icon",
            tint = Color.Black
        )

        if (hasNotifications) {
            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                drawCircle(
                    color = Color.White,
                    radius = size.height / 7f,
                    center = Offset(size.width / 1.4f, size.height / 3f)
                )

                drawCircle(
                    color = CryptoOrange,
                    radius = size.height / 11f,
                    center = Offset(size.width / 1.4f, size.height / 3f)
                )

            })
        }

    }
}

