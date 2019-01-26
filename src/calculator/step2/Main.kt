package calculator.step2

import calculator.verifyRegex

/*
* CALCULATOR PROJECT
* It is a project of building a calculator for 6 operations: +, -, *, /, ! and ^
* The goal is performing calculations like [(1+2)*3-4*{10+3})ˆ3]!, for example
* */

/*
* STEP 2
* In this step, the calculator is prepared to performing 2 operations: +, - and * .
* It receives a string and performs its calculation (all numbers, including decimal ones)
* */






fun main() {
    val calculator = CalculatorStep2("")
    print("2+2+5-4 = ")
    println(calculator.setText("2  + 2   + 5-   4").calculate())
    print("2+7-3+5-1-9+4 = ")
    print(calculator.setText(" 2 +7- 3+ 5-   1 -9 +       4     ").calculate())
}
