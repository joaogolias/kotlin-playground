package calculator.step2

import calculator.verifyRegex

class CharSequenceConverter {
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
