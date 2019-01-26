package enums


enum class OperationType(val value: Int, val operationSymbol: String) {
    SUM(0, "+"),
    SUBTRACT(1, "-"),
    MULTIPLY(2, "*")
}

val operations = OperationType.values().associateBy(OperationType::operationSymbol)

fun main() {
    println(operations["+"])
}
