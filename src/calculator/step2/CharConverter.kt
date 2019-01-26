package calculator.step2

import calculator.verifyRegex

class CharConverter {

    fun isNumberChar(test: Char): Boolean {
        if(test.verifyRegex("^[0-9]$")) {
            return true
        }
        if(test.toString().contains('.')) {
            return true
        }
        return false
    }

    fun <K, V>isOperation(validOperations: Map<K,V>, test: K): Boolean {
        return validOperations.containsKey(test)
    }

    fun convertToFloat(text: String): Float {
        return text.toFloat()
    }

    fun <K, V>convertToOperationType(validOperations: Map<K,V>, operationKey: K): V {
        return validOperations.getValue(operationKey)
    }
}
