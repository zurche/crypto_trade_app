package com.az.cryptotradeapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.az.cryptotradeapp.ui.theme.FullWhite
import com.az.cryptotradeapp.ui.theme.PaleWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAMainScreen() {

    Scaffold(bottomBar = {
        CTABottomNavigationBar()
    }, content = { paddingValues ->
        Card(
            modifier = Modifier
                .background(color = FullWhite)
                .fillMaxSize()
                .padding(paddingValues),
            colors = CardDefaults.cardColors(
                containerColor = PaleWhite
            ),
            shape = RoundedCornerShape(30.dp)
        ) {

        }
    })
}