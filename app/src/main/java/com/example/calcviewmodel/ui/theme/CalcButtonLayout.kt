package com.example.calcviewmodel.ui.theme

import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calcviewmodel.CalcAction
import com.example.calcviewmodel.CalcButton
import com.example.calcviewmodel.CalcData
import com.example.calcviewmodel.CalcOperation

val RowModifier = Modifier
    .fillMaxWidth()

@Composable
fun CalcButtonLayout(
    state: CalcData,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 5.dp,
    rowSpacing: Dp = 8.dp,
    onAction: (CalcAction) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(rowSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 80.sp,
                color = Colors.outputWhite,
                maxLines = 2
            )
            Row (
                modifier = RowModifier,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(2F)
                        .weight(2F),
                    onClick ={
                        onAction(CalcAction.Clear)
                    })
                CalcButton(
                    symbol = "<-",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Delete)
                    })
                CalcButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.operation(CalcOperation.Divide))
                    })
            }
            Row (
                modifier = RowModifier,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(7))
                    })
                CalcButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(8))
                    })
                CalcButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(9))
                    })
                CalcButton(
                    symbol = "*",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.operation(CalcOperation.Multiply))
                    })
            }
            Row (
                modifier = RowModifier,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(4))
                    })
                CalcButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(5))
                    })
                CalcButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(6))
                    })
                CalcButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.operation(CalcOperation.Subtract))
                    })
            }
            Row (
                modifier = RowModifier,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(1))
                    })
                CalcButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(2))
                    })
                CalcButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(3))
                    })
                CalcButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.operation(CalcOperation.Add))
                    })
            }
            Row (
                modifier = RowModifier,
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                CalcButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Colors.lightGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.operation(CalcOperation.Percent))
                    })
                CalcButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Colors.numberButtonGrey)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Number(0))
                    })
                CalcButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Colors.lightGray)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Decimal)
                    })
                CalcButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Colors.actionButtonOrange)
                        .aspectRatio(1F)
                        .weight(1F),
                    onClick = {
                        onAction(CalcAction.Calculate)
                    })
            }
        } 
    }
    
}