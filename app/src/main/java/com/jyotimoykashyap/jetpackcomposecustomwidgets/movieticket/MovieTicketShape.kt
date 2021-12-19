package com.jyotimoykashyap.jetpackcomposecustomwidgets.movieticket

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class MovieTicketShape(private val cornerSize: Float, private val cutFraction: Float = 0.65f) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawMovieTicketPath(size = size, cornerSize = cornerSize, cutFraction = cutFraction)
        )
    }
}

fun drawMovieTicketPath(size: Size, cornerSize: Float, cutFraction: Float) : Path{
    return Path().apply {

        // reset the path
        reset()

        // draw the top line
        lineTo(x = size.width, y = 0f)

        // I want the lines toward left and right side to just extend till 60% of the total
        // height of the actual size.

        // draw the right line
        lineTo(x = size.width, y = (cutFraction*size.height).toFloat() - cornerSize)

        // draw the arc of the ticket on the right side
        arcTo(
            rect = Rect(
                left = size.width - cornerSize,
                top = (cutFraction*size.height).toFloat() - cornerSize,
                right = size.width + cornerSize,
                bottom = (cutFraction*size.height).toFloat() + cornerSize
            ),
            startAngleDegrees = -90.0f,
            sweepAngleDegrees = -180.0f,
            forceMoveTo = false
        )

        // right remaining line
        lineTo(x = size.width, y = size.height)

        // bottom line
        lineTo(x = 0f, y = size.height)

        // left remaining line
        lineTo(x = 0f, y = (cutFraction*size.height).toFloat() + cornerSize)

        // draw the arc of the ticket on the left side
        arcTo(
            rect = Rect(
                left = -cornerSize,
                top = (cutFraction*size.height).toFloat() - cornerSize,
                right = +cornerSize,
                bottom = (cutFraction*size.height).toFloat() + cornerSize
            ),
            startAngleDegrees = 90.0f,
            sweepAngleDegrees = -180.0f,
            forceMoveTo = false
        )

        // draw the left line
        lineTo(x = 0f, y = 0f)

        close()

    }
}