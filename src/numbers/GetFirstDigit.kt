package numbers

fun Int.getFirstDigit(): Int {
    var firstDigit = this
    while(firstDigit > 10) {
        firstDigit /= 10
    }
    return firstDigit
}

fun Float.getFirstDigit(): Int {
    return this.toInt().getFirstDigit()
}


fun main(){
    print("Primerio digito de 123: ")
    println(123.getFirstDigit())

    print("Primerio digito de 0: ")
    println(0.getFirstDigit())


    print("Primerio digito de 54: ")
    println(54.getFirstDigit())

    print("Primerio digito de 134.56: ")
    println((134.56f).getFirstDigit())

    print("Primerio digito de 897134.1342: ")
    println("897134.1342".toFloat().getFirstDigit())

    print("Primerio digito de 1: ")
    println("1".toFloat().getFirstDigit())
}
