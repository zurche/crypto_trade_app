package com.az.cryptotradeapp.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAMainScreen() {

    Scaffold(bottomBar = {
        CTABottomNavigationBar()
    }, content = { paddingValues ->
        Text(modifier = Modifier.padding(paddingValues), text = "Hello World")
    })
}