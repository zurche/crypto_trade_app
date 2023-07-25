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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.az.cryptotradeapp.R
import com.az.cryptotradeapp.ui.theme.CryptoOrange

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAHomeHeader(modifier: Modifier = Modifier) {
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
                    .fillMaxHeight()
                    .clip(CircleShape),
                model = "https://cdn-icons-png.flaticon.com/512/5969/5969010.png",
                contentDescription = "Profile Picture"
            )

            CTANotificationsIcon()

        }

        CTATodayValue()
    }
}

@Composable
@Preview(showBackground = true)
private fun CTATodayValue() {
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
                text = "+980.60",
                color = CryptoOrange,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.displaySmall
            )

            Text(
                modifier = Modifier.padding(start = 5.dp, bottom = 3.dp),
                text = "USD",
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

