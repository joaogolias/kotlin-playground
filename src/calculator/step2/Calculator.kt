package calculator.step2
import LogicManager

class Calculator(private var text: String) {
    fun setText(text: String): Calculator {
        this.text = text
        return this
    }

    fun calculate(): Float {
        return LogicManager(text).result
    }
}
