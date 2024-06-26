package com.example.calcviewmodel

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calcviewmodel.ui.theme.Colors


@Composable
fun CalcButton(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .then(modifier)
    ){
        Text(
            text = symbol,
            fontSize = 30.sp,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)
            )
    }
}

@Preview
@Composable
fun RoundButtonPreview() {
    Row(Modifier.fillMaxWidth().wrapContentHeight()) {
        CalcButton(symbol = "4", modifier = Modifier
            .background(color = Colors.numberButtonGrey)
            .aspectRatio(1f)) {
        }
        CalcButton(symbol = "4", modifier = Modifier
            .background(color = Colors.numberButtonGrey)
            .aspectRatio(1f)) {
        }
        CalcButton(symbol = "4", modifier = Modifier
            .background(color = Colors.numberButtonGrey)
            .aspectRatio(1f)) {
        }
    }
}

