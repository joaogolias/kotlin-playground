package calculator.step2

/*
* CALCULATOR PROJECT
* It is a project of building a calculator for 6 operations: +, -, *, /, ! and ^
* The goal is performing calculations like [(1+2)*3-4*{10+3})ˆ3]!, for example
* */

/*
* STEP 2
* In this step, the calculator is prepared to performing 2 operations: +, - and * .
* It receives a string and performs its calculation (all numbers, including decimal ones)
* It also respects math priority operation
* */

fun main() {
    val calculator = Calculator("")
    var text = "2+2.5*2+2*3-2*10"
    print("${text} = ")
    println(calculator.setText(text).calculate())
}

