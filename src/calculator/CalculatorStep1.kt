package calculator

import java.io.IOException

/*
* CALCULATOR PROJECT
* It is a project of building a calculator for 6 operations: +, -, *, /, ! and ^
* The goal is performing calculations like [(1+2)*3-4*{10+3})ˆ3]!, for example
* */

/*
* STEP 1
* In this step, the calculator is prepared to performing 2 operations: + and - .
* It receives a string and perform it calculation (numbers 0 to 9)
* */
class Calculator(private var text: String) {
    fun setText(text: String) {
        this.text = text
    }

    fun calculate(): Float {
        return TextToOperationConversor(text).result
    }
    enum class OperationType(val value: Int) {
        SUM(0),
        SUBTRACT(1),
    }

    class ArithmeticLogic(private var x: Float, private var y: Float, private var operationType: OperationType) {
        var result: Float = -1f
        get() {
            return when (this.operationType) {
                OperationType.SUM -> x + y
                OperationType.SUBTRACT -> x - y
            }
        }

        fun reset(x: Float?, y: Float?, operationType: OperationType?) {
            x?.let { this.x = it}
            y?.let { this.y = it}
            operationType?.let { this.operationType = it}
        }
    }

    class TextToOperationConversor(private var text: String){
        private var numberList: MutableList<Float> = mutableListOf()
        private var operations: MutableList<OperationType> = mutableListOf()
        var result: Float = -1f
        get() {
            this.setLists()
            val arithmeticLogic = ArithmeticLogic(-1f, -1f, OperationType.SUM)
            var partialResult: Float = 0f
            numberList.forEachIndexed{index, number ->
                if(index == 0) partialResult = number
                else{
                    arithmeticLogic.reset(partialResult, number, operations[index-1])
                    partialResult = arithmeticLogic.result
                }
            }
            return partialResult
        }

        private fun setLists() {
            this.text = this.text.replace(Regex(" +"), "")
            for (char in text) {
                try {
                    val number = char.toString().toFloat()
                    numberList.add(number)
                } catch(e: NumberFormatException){
                    val operation = this.mapOperationStringToOperationType(char)
                    operations.add(operation)
                }
            }
        }

        private fun mapOperationStringToOperationType(operationString: Char): OperationType {
            val operationType =  when (operationString) {
                '+' -> OperationType.SUM
                '-' -> OperationType.SUBTRACT
                else -> null
            }
            operationType?.let {return operationType}
            throw IOException("Invalid operation found")
        }
    }
}

fun main() {
    print("2+2+5-4 = ")
    println(Calculator("2  + 2   + 5-   4").calculate())
    print("2+7-3+5-1-9+4 = ")
    print(Calculator(" 2 +7- 3+ 5-   1 -9 +       4     ").calculate())
}
