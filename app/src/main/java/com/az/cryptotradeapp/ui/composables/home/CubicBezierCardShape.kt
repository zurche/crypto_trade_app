package com.az.cryptotradeapp.ui.composables.home

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CubicBezierCardShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            // Top left corner
            moveTo(x = height.times(.02f), y = height.times(.25f))

            val topLeftControlPoint1 = Offset(width.times(.02f), height.times(.03f))
            val topLeftControlPoint2 = Offset(width.times(.03f), height.times(.02f))

            cubicTo(
                x1 = topLeftControlPoint1.x,
                y1 = topLeftControlPoint1.y,
                x2 = topLeftControlPoint2.x,
                y2 = topLeftControlPoint2.y,
                x3 = width.times(.25f),
                y3 = height.times(.02f)
            )

            // Top right corner
            lineTo(x = width.times(.75f), y = height.times(.02f))

            val topRightControlPoint1 = Offset(width.times(.97f), height.times(.02f))
            val topRightControlPoint2 = Offset(width.times(.98f), height.times(.03f))

            cubicTo(
                x1 = topRightControlPoint1.x,
                y1 = topRightControlPoint1.y,
                x2 = topRightControlPoint2.x,
                y2 = topRightControlPoint2.y,
                x3 = width.times(.98f),
                y3 = height.times(.25f)
            )

            // Bottom right corner
            lineTo(x = width.times(.98f), y = height.times(.75f))

            val bottomRightControlPoint1 = Offset(width.times(.97f), height.times(.98f))
            val bottomRightControlPoint2 = Offset(width.times(.98f), height.times(.97f))

            cubicTo(
                x1 = bottomRightControlPoint1.x,
                y1 = bottomRightControlPoint1.y,
                x2 = bottomRightControlPoint2.x,
                y2 = bottomRightControlPoint2.y,
                x3 = width.times(.75f),
                y3 = height.times(.98f)
            )

            // Bottom left corner
            lineTo(x = width.times(.25f), y = height.times(.98f))

            val bottomLeftControlPoint1 = Offset(width.times(.03f), height.times(.98f))
            val bottomLeftControlPoint2 = Offset(width.times(.02f), height.times(.97f))

            cubicTo(
                x1 = bottomLeftControlPoint1.x,
                y1 = bottomLeftControlPoint1.y,
                x2 = bottomLeftControlPoint2.x,
                y2 = bottomLeftControlPoint2.y,
                x3 = width.times(.02f),
                y3 = height.times(.75f)
            )

            close()
        }

        return Outline.Generic(path)
    }
}