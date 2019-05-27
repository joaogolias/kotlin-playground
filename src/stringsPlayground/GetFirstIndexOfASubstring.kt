package stringsPlayground

fun String.getFirstIndexOf(substring: String): Int {
    return indexOf(substring)
}

fun main() {
    val s = "Olá, sou João Golias"
    val startIndex = s.indexOf("sou")
    val finalIndex = startIndex + "sou".length
    println(startIndex)
    println(finalIndex)
    println("${s.subSequence(startIndex, finalIndex)}")
    println(s.subSequence(startIndex, finalIndex).length)
}
