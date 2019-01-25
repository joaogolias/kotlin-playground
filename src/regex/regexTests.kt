package regex

class regexTests {
}

fun main () {
    val x = "tenho  dois espaços"
    val y = x.replace(Regex("  +"),  " ")
    println(x)
    println(y)
    println(x == y)
}
