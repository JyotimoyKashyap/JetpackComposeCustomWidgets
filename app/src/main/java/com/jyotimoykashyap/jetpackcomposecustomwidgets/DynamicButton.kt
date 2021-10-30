package com.jyotimoykashyap.jetpackcomposecustomwidgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun DynamicButton(
    cornerSize: Dp = 8.dp,
    elevation: Dp = 8.dp,
    progressValue: Int = 280
){

    var clicked by remember {
        mutableStateOf(false)
    }

    var allowedProgress by remember {
        mutableStateOf(400)
    }

    allowedProgress = if(progressValue <= 400){
        progressValue
    }else 400

    var animatedProgressValue by remember {
        mutableStateOf(0f)
    }

    LaunchedEffect(key1 = allowedProgress){
        animatedProgressValue = allowedProgress.toFloat()
    }

    val animatedValue by animateFloatAsState(
        targetValue = animatedProgressValue,
        animationSpec = tween(
            durationMillis = 1500,
            easing = FastOutSlowInEasing,
            delayMillis = 1000
        )
    )

    Surface(
        onClick = {clicked = !clicked},
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.background,
        elevation = elevation,
        modifier = Modifier
            .padding(
            4.dp
        )
    ) {

        Box(
            modifier = Modifier
                .size(
                    height = 45.dp,
                    width = 120.dp
                )
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(14.dp)
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
                .drawBehind {
//                    if(clicked){
                    drawLine(
                        brush = Brush.horizontalGradient(
                            listOf(Color.Blue, Color.Blue)
                        ),
                        start = Offset(
                            x = -40F,
                            y = (62).toFloat()
                        ),
                        end = Offset(
                            // this x value will be changing
                            x = animatedValue,
                            y = (62).toFloat()
                        ),
                        strokeWidth =
                        if(animatedValue == (0).toFloat()){ 0.0f }
                        else 130.0f,
                        cap = StrokeCap.Square
                    )
//                    }
                },
            contentAlignment = Alignment.Center
        ){
            if(!clicked){
                Text(
                    text = "Download",
                    fontSize = 16.sp,
                    color = Color.White
                )

            }

        }

    }
}


@ExperimentalMaterialApi
@Composable
@Preview
fun DynamicButtonPreview(){
    DynamicButton()
}