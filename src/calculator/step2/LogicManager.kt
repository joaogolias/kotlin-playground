import calculator.verifyRegex

class LogicUnit(private var text: String){
    private var numberList: MutableList<Float> = mutableListOf()
    private var operations: MutableList<OperationType> = mutableListOf()
    val validOperations = OperationType.values().associateBy(OperationType::operationSymbol)

    var result: Float = -1f
        get()  {
            this.setLists()
            var partialResult = 0f
            numberList.forEachIndexed{ index, number ->
                if(index == 0) partialResult = number
                else {
                    val operation = operations[index-1]
                    partialResult = operation.run(partialResult, number)
                }
            }
            return partialResult
        }

    private fun setLists() {
        this.text = this.text.replace(Regex(" +"), "")
        for (char in text) {
            var finalNumber = ""
            if(isNumber(char)) {
                finalNumber += char
            } else {
                if(isOperation(char)) {
                    val convertedOperation = convertToOperationType(char)
                    operations.add(convertedOperation)

                    val convertedNumber = convertToFloat(finalNumber)
                    numberList.add(convertedNumber)
                }
            }
        }
    }

    private fun isNumber(test: Char): Boolean {
        if(test.verifyRegex("^[0-9]$")) {
            return true
        }
        if(test.toString().contains('.')) {
            return true
        }
        return false
    }

    private fun isOperation(test: Char): Boolean {
        return validOperations.containsKey(test)
    }

    private fun convertToFloat(text: String): Float {
        return text.toFloat()
    }

    private fun convertToOperationType(operationKey: Char): OperationType {
        return validOperations.getValue(operationKey)
    }

}
