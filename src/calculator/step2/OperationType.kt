enum class OperationType(val value: Int, val operationSymbol: Char, val priority: Int) {
    SUM(0, '+', 0){
        override fun run(x: Float, y: Float): Float {
            return x+y
        }
    },
    SUBTRACT(1, '-', 1){
        override fun run(x: Float, y: Float): Float {
            return x-y
        }
    },
    MULTIPLY(2, '*', 2){
        override fun run(x: Float, y: Float): Float {
            return x*y
        }
    };

    abstract fun run(x: Float, y: Float): Float
}
