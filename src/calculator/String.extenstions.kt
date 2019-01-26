package calculator

fun String.verifyRegex(condition: String): Boolean {
    return this.matches(Regex(condition))
}

fun Char.verifyRegex(condition: String): Boolean {
    return this.toString().verifyRegex(condition)
}

fun main() {
    println('2'.verifyRegex("^[0-9]$"))
    println("21".verifyRegex("^[0-9]$"))
    println("a".verifyRegex("^[0-9]$"))
}
