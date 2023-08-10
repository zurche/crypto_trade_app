package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.az.cryptotradeapp.ui.theme.CryptoOrange2
import com.az.cryptotradeapp.ui.theme.CryptoOrange3
import com.az.cryptotradeapp.ui.theme.CryptoOrange4
import kotlinx.coroutines.delay

data class MyCryptoCapUIData(
    val value: Float,
    val currency: String,
    val monthlyPreview: List<Pair<String, Float>>
)

private val mockData =
    MyCryptoCapUIData(
        38546.82f,
        "USD",
        listOf(
            Pair("Jan", 15000f),
            Pair("Feb", 20000f),
            Pair("Mar", 38000f),
            Pair("Apr", 8000f),
            Pair("May", 10000f)
        )
    )

@Composable
@Preview(device = Devices.PIXEL_4, showBackground = true)
fun CTAMyCryptoCap(modifier: Modifier = Modifier, data: MyCryptoCapUIData = mockData) {

    var animatedVisibility by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(200)
        animatedVisibility = true
    }

    val verticalOrangeGradient = Brush.radialGradient(
        colors = listOf(
            CryptoOrange2,
            CryptoOrange3
        ),
        center = Offset(200f, 150f)
    )

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(300.dp),
        shape = CubicBezierCardShape(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        AnimatedVisibility(
            visible = animatedVisibility,
            enter = fadeIn() + slideInHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(verticalOrangeGradient)
                    .drawBehind { drawCurvyLine() }
            ) {
                Column(
                    modifier = Modifier.padding(
                        top = 50.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 15.dp
                    )
                ) {
                    Text(
                        text = "My Crypto Cap",
                        color = Color.White,
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.ExtraLight
                    )

                    Text(
                        modifier = Modifier.padding(bottom = 25.dp),
                        text = "${data.value} ${data.currency}",
                        color = Color.White,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.ExtraBold
                    )

                    MonthlyCapPreview(data.monthlyPreview)
                }

            }
        }

    }
}

@Composable
fun MonthlyCapPreview(monthlyPreview: List<Pair<String, Float>>) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val maxMonthValue = monthlyPreview.maxBy { it.second }.second
        Row(
            modifier = Modifier.fillMaxHeight(.8f),
            verticalAlignment = Alignment.Bottom
        ) {
            for (pairPreview in monthlyPreview) {
                val columnHeightWeight = pairPreview.second / maxMonthValue
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(columnHeightWeight)
                        .padding(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = setHighlightColor(
                            pairPreview,
                            maxMonthValue
                        )
                    ),
                    shape = RoundedCornerShape(30)
                ) { }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            for (pairPreview in monthlyPreview) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = pairPreview.first,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = setHighlightColor(pairPreview, maxMonthValue)
                )
            }
        }
    }
}

@Composable
private fun setHighlightColor(
    pairPreview: Pair<String, Float>,
    maxMonthValue: Float
) = if (pairPreview.second == maxMonthValue) Color.White else Color.White.copy(
    alpha = 0.4f
)

private fun DrawScope.drawCurvyLine() {
    val stroke = Path().apply {
        moveTo(size.width.times(.9f), size.height.times(0f))

        quadraticBezierTo(
            size.width.times(.9f), size.height.times(.28f),
            size.width.times(.73f), size.height.times(.15f)
        )

        quadraticBezierTo(
            size.width.times(.53f), size.height.times(0f),
            size.width.times(.55f), size.height.times(.25f)
        )
    }

    drawPath(
        stroke,
        color = CryptoOrange4,
        style = Stroke(
            width = 50f,
            cap = StrokeCap.Round
        )
    )
}