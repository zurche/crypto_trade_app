package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.az.cryptotradeapp.R

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAHomeHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            AsyncImage(
                modifier = Modifier.fillMaxHeight().clip(CircleShape),
                model = "https://cdn-icons-png.flaticon.com/512/5969/5969010.png",
                contentDescription = "Profile Picture"
            )

            Icon(
                modifier = Modifier.fillMaxHeight().graphicsLayer(rotationZ = 30f),
                painter = painterResource(id = R.drawable.bell_outline),
                contentDescription = "Notifications Icon",
                tint = Color.Black
            )
        }
        Row {

        }
    }
}

