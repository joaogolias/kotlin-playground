package stringsPlayground

fun main() {
    var text = "53542"
    println(text)
    val index = text.length-1
    text = text.replaceRange(index, index + 1, "02")
    println(text)
}
