package calculator.step2

import enums.OperationType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class CharConverterTest {
    private lateinit var charConverter: CharConverter
    private val validOperations = OperationType.values().associateBy(OperationType::operationSymbol)

    @BeforeAll()
    fun setUp(){
        charConverter = CharConverter()
    }

    @Test()
    fun `should identify number`() {
        val value = '2'
        val isNumberChar= charConverter.isNumberChar(value)
        Assertions.assertEquals(isNumberChar, true)
    }

    @Test()
    fun `should return a number`() {
        val value = "50.45"
        val newNumber = charConverter.convertToFloat(value)
        Assertions.assertEquals(newNumber, 50.45f)
    }

    @Test()
    fun `should identify dot as number char`() {
        val value = '.'
        val isNumberChar= charConverter.isNumberChar(value)
        Assertions.assertEquals(isNumberChar, true)
    }

    @Test()
    fun `should identify operation char`() {
        val value = "+"
        val isOperationChar = charConverter.isOperation(validOperations, value)
        Assertions.assertEquals(isOperationChar, true)
    }
}
