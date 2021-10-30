package com.jyotimoykashyap.jetpackcomposecustomwidgets

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun DynamicButton(
    cornerSize: Dp = 8.dp,
    elevation: Dp = 8.dp
){

    var clicked by remember {
        mutableStateOf(false)
    }

    Surface(
        onClick = {clicked = !clicked},
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.primary,
        elevation = elevation,
        modifier = Modifier.padding(
            4.dp
        )
    ) {

        Box(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                )
        ){
            if(!clicked){
                Text(
                    text = "Download",
                    fontSize = 16.sp
                )
            }else{
                CircularProgressIndicator(
                    color = MaterialTheme.colors.surface,
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