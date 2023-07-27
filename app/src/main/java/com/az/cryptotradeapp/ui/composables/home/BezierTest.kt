package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.az.cryptotradeapp.ui.theme.CryptoOrange

@Composable
@Preview(showBackground = true)
fun BezierTest() {
    Canvas(modifier = Modifier.size(300.dp), onDraw = {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            moveTo(x = height.times(.1f), y = height.times(.25f))

            // Top left corner
            quadraticBezierTo(
                x1 = width.times(.12f),
                y1 = height.times(.12f),
                x2 = width.times(.25f),
                y2 = height.times(.1f)
            )

            lineTo(x = width.times(.75f), y = height.times(.1f))

            // Top right corner
            quadraticBezierTo(
                x1 = width.times(.88f),
                y1 = height.times(.12f),
                x2 = width.times(.9f),
                y2 = height.times(.25f)
            )

            lineTo(x = width.times(.9f), y = height.times(.75f))

            // Bottom right corner
            quadraticBezierTo(
                x1 = width.times(.88f),
                y1 = height.times(.88f),
                x2 = width.times(.75f),
                y2 = height.times(.9f)
            )

            lineTo(x = width.times(.25f), y = height.times(.9f))

            // Bottom left corner
            quadraticBezierTo(
                x1 = width.times(.12f),
                y1 = height.times(.88f),
                x2 = width.times(.1f),
                y2 = height.times(.75f)
            )
            close()
        }
        drawPath(path = path, color = CryptoOrange)
    })
}