package com.example.calcviewmodel

sealed class CalcOperation(val symbol: String) {
    object Add: CalcOperation("+")
    object Subtract: CalcOperation("-")
    object Multiply: CalcOperation("*")
    object Divide: CalcOperation("/")
}