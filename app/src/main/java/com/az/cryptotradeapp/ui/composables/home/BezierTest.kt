package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
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

            // Top left corner
            moveTo(x = height.times(.02f), y = height.times(.2f))

            val topLeftControlPoint = Offset(width.times(.02f), height.times(.02f))

            cubicTo(
                x1 = topLeftControlPoint.x,
                y1 = topLeftControlPoint.y,
                x2 = topLeftControlPoint.x,
                y2 = topLeftControlPoint.y,
                x3 = width.times(.2f),
                y3 = height.times(.02f)
            )

            // Top right corner
            lineTo(x = width.times(.8f), y = height.times(.02f))

            val topRightControlPoint = Offset(width.times(.98f), height.times(.02f))

            cubicTo(
                x1 = topRightControlPoint.x,
                y1 = topRightControlPoint.y,
                x2 = topRightControlPoint.x,
                y2 = topRightControlPoint.y,
                x3 = width.times(.98f),
                y3 = height.times(.2f)
            )

            // Bottom right corner
            lineTo(x = width.times(.98f), y = height.times(.8f))

            val bottomRightControlPoint = Offset(width.times(.98f), height.times(.98f))

            cubicTo(
                x1 = bottomRightControlPoint.x,
                y1 = bottomRightControlPoint.y,
                x2 = bottomRightControlPoint.x,
                y2 = bottomRightControlPoint.y,
                x3 = width.times(.8f),
                y3 = height.times(.98f)
            )

            // Bottom left corner
            lineTo(x = width.times(.2f), y = height.times(.98f))

            val bottomLeftControlPoint = Offset(width.times(.02f), height.times(.98f))

            cubicTo(
                x1 = bottomLeftControlPoint.x,
                y1 = bottomLeftControlPoint.y,
                x2 = bottomLeftControlPoint.x,
                y2 = bottomLeftControlPoint.y,
                x3 = width.times(.02f),
                y3 = height.times(.8f)
            )

            close()
        }
        drawPath(path = path, color = CryptoOrange)
    })
}