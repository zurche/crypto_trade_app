package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.az.cryptotradeapp.ui.theme.CryptoOrange2
import com.az.cryptotradeapp.ui.theme.CryptoOrange3
import com.az.cryptotradeapp.ui.theme.FullWhite

data class MyCryptoCapUIData(val value: Float, val currency: String)

private val mockData = MyCryptoCapUIData(38546.82f, "USD")

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAMyCryptoCap(modifier: Modifier = Modifier, data: MyCryptoCapUIData = mockData) {

    val verticalOrangeGradient = Brush.verticalGradient(
        colors = listOf(
            CryptoOrange2,
            CryptoOrange3
        )
    )

    Card(
        modifier = Modifier
            .background(color = FullWhite)
            .padding(10.dp)
            .fillMaxWidth()
            .height(300.dp),
        shape = RoundedCornerShape(20)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(verticalOrangeGradient)
        ) {
            Column(modifier = Modifier.padding(top = 50.dp, start = 30.dp)) {
                Text(
                    text = "My Crypto Cap",
                    color = Color.White,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.ExtraLight
                )

                Text(
                    text = "${data.value} ${data.currency}",
                    color = Color.White,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.ExtraBold
                )
            }

        }
    }
}