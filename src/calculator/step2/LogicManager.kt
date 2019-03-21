import calculator.step2.CharConverter
import calculator.step2.OperationIdentifier

class LogicManager(private var text: String){
    private var numberList: MutableList<Float?> = mutableListOf()
    private var operations: MutableList<OperationIdentifier> = mutableListOf()
    val charConverter = CharConverter()
    val validOperations = OperationType.values().associateBy(OperationType::operationSymbol)

    var result: Float = -1f
        get()  {
            this.setLists()
            var partialResult: Float
            val operationList = operations.toList().sortedByDescending { it.type.priority }
            operationList.forEachIndexed { index, operation ->
                var firstOperandIndex = operation.firstOperandIndex
                var secondOperandIndex = operation.seconOperandIndex
                while(numberList[firstOperandIndex] == null && firstOperandIndex != 0) {
                    firstOperandIndex--
                }
                while(numberList[secondOperandIndex] == null && secondOperandIndex != 0){
                    secondOperandIndex--
                }
                partialResult = operation.type.run(
                    numberList[firstOperandIndex] ?: 0f,
                    numberList[secondOperandIndex] ?: 0f)
                numberList[firstOperandIndex] = partialResult
                numberList[secondOperandIndex] = null
            }
            return numberList[0] ?: 0f
        }

    private fun setLists() {
        this.text = this.text.replace(Regex(" +"), "")
        var finalNumber = ""
        var operationArrayIndex = 0
        text.forEachIndexed { index, char ->
            if(charConverter.isNumberChar(char)) {
                finalNumber += char.toString()
                if(index == text.length - 1) {
                    val convertedNumber = charConverter.convertToFloat(finalNumber)
                    numberList.add(convertedNumber)
                }
            } else {
                if((charConverter.isOperation(validOperations, char))) {
                    val convertedOperation = charConverter.convertToOperationType(validOperations, char)
                    operations.add(OperationIdentifier(convertedOperation, operationArrayIndex, operationArrayIndex+1))
                    operationArrayIndex++
                }
                val convertedNumber = charConverter.convertToFloat(finalNumber)
                numberList.add(convertedNumber)
                finalNumber = ""
            }

        }
    }
}
