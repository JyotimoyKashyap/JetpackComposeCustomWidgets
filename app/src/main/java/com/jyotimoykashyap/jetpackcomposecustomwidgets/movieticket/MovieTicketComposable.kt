package com.jyotimoykashyap.jetpackcomposecustomwidgets.movieticket


import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MovieTicketComposable(){

    Surface(
        shape = MovieTicketShape(30f, 0.70f),
        color = Color.White,
        modifier = Modifier
            .size(
                width = 200.dp,
                height = 150.dp
            )
    ) {


    }

}
@Composable
@Preview
fun MovieTicketPreview(){
    MovieTicketComposable()
}