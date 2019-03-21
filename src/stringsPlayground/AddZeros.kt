package stringsPlayground

class AddZeros {
}

fun String.addZerosUntilLength(quantity: Int): String {
    var result = this
    if(this.length < quantity) {
        for(i in 1..(quantity-this.length)) {
            result = "0$result"
        }
    }
    return result
}

fun main() {
    println("1".addZerosUntilLength(4))
    println("12".addZerosUntilLength(4))
    println("123".addZerosUntilLength(4))
    println("1234".addZerosUntilLength(4))
    println("12345".addZerosUntilLength(4))
    println("12345".addZerosUntilLength(6))
}


