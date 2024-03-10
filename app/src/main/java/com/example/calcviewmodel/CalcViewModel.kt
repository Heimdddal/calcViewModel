package com.example.calcviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalcViewModel: ViewModel() {
    var state by mutableStateOf(CalcData())
        private set

    fun onAction(action: CalcAction){
        when(action){
            is CalcAction.Number -> enterNumber(action.number)
            is CalcAction.Decimal -> enterDecimal()
            is CalcAction.Clear -> state = CalcData()
            is CalcAction.Operation -> enterOperation(action.operation)
            is CalcAction.Calculate -> performCalculation()
            is CalcAction.Delete -> performDeletion()
            is CalcAction.Percent -> performPercentage()
        }
    }

    private fun performPercentage() {
        if (state.operation == null && state.number1.isNotBlank()) {
            state = state.copy(number1 = (state.number1.toDouble() / 100).toString().take(8))
        }
    }

    private fun performDeletion() {
        when{
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            state.operation != null ->  state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when(state.operation){
                is CalcOperation.Add -> number1 + number2
                is CalcOperation.Subtract -> number1 - number2
                is CalcOperation.Multiply -> number1 * number2
                is CalcOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(8), // TODO {Нужно сделать так, чтобы при отсутствующей дробной части число выводилось без него, иначе можно поймать момент, когда в конце числа просто будет стоять точка. Также решить проблему с выводом двух строчек и уменьшать шрифт при достижении максимальной длинны}
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(operation: CalcOperation) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.number2.isNotBlank() && !state.number2.contains(".")
            && state.operation != null) {
            state = state.copy(number2 = state.number2 + ".")
        } else if (state.number1.isNotBlank() && !state.number1.contains(".")) {
            state = state.copy(number1 = state.number1 + ".")
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if(state.number1.length >= MAX_NUM_LENGTH) return
            state = state.copy(number1 = state.number1 + number)
            return
        }

        if (state.number2.length >= MAX_NUM_LENGTH) return
        state = state.copy(number2 = state.number2 + number)

    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}