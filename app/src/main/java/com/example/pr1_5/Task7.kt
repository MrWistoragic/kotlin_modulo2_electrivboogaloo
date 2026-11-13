package com.example.pr1_5

import android.R.attr.padding
import android.annotation.SuppressLint
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import android.R.attr.height
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.ui.unit.Dp
import android.view.Gravity.apply
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight


data class Contact(val name: String, val address: String)

@Composable
fun ContactColumnPreview() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        ContactItemColumn("Артур", "г. Москва, ул. Чайная д67")
        ContactItemColumn("Борис", "г. Москва, ул. Строителей...")
        ContactItemColumn("Иван", "г. Москва, ул. Строителей...")
    }
}
@Preview
@Composable
fun ContactItemPreview() {
    ContactItemColumn( "Артур", "г. Москва, ул. Чайная д67")
}


@Composable
internal fun ContactItemColumn(name: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = name, fontWeight = FontWeight.Bold)
        Text(text = address, textAlign = TextAlign.Center)
    }
}

@Preview
@Composable
fun ContactRowPreview() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Имя: Артур", fontWeight = FontWeight.Bold)
            Text(text = "Адрес: г. Москва...")
        }
        Text(
            text = "*",
            color = Color.Yellow,
            fontSize = 24.sp,
        )
    }
}
