package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAHomeHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row {
            AsyncImage(
                model = "https://cdn-icons-png.flaticon.com/512/5969/5969010.png",
                contentDescription = "Profile Picture"
            )
        }
        Row {

        }
    }
}

