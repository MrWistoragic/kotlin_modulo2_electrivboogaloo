package com.example.pr1_5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pr1_5.ui.theme.Pr15Theme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column


@Preview(name = "Portrait", showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable

fun PreviewPortrait() {
    Greeting("Акс портретный", Modifier.fillMaxSize())
}

@Preview(name = "Landscape", showBackground = true, widthDp = 891, heightDp = 411)
@Composable
fun PreviewLandscape() {
    Greeting("Акс ландшафтный", Modifier.fillMaxSize())
}

@Preview(name = "Round", showBackground = true, widthDp = 200, heightDp = 200,
    backgroundColor = 0xFF410665
)
@Composable
fun PreviewRound() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Greeting("Акс кругообразный")
    }
}

@Preview(name = "Combined", showBackground = true)
@Composable
fun PowersCombined() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PreviewLandscape()
            PreviewPortrait()
            PreviewRound()
        }
    }
}