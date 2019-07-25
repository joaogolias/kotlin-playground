package regex

enum class CustomRegex(val value: String) {
//    CARD("(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})\$"),
    CARD("[0-9]+{16}" ),
    CARD_DATE("(([0-2][0-9])|((3)[0-1]))(\\/)(((0)[0-9])|((1)[0-2]))"),
    NEW_CARD_DATE("(([0][1-9])|([1][1-2]))(\\/)([0-9]{2})"),
    CVV("([0-9]{3})"),
    ONLY_NUMBERS("(^[0-9]*$)"),
    EXACTLY_3_DIGITS("^[0-9]{3}$")
}
object RegexValidation {

    fun validate(text: String, regex: CustomRegex): Boolean {
        return text.matches(Regex(regex.value))
    }

    fun validate(text: String, regex: Regex): Boolean {
        return text.matches(regex)
    }
}

fun main () {
//    println("  3 2342 \n   4".replace("( +)|(\n)".toRegex(), ""))
    println(CustomRegex.EXACTLY_3_DIGITS.value.toRegex().find("1234"))
    println(CustomRegex.EXACTLY_3_DIGITS.value.toRegex().find("321444"))
    println(CustomRegex.EXACTLY_3_DIGITS.value.toRegex().find("233")?.value)
    println(CustomRegex.EXACTLY_3_DIGITS.value.toRegex().find("0001"))
//
//    println(RegexValidation.validate("02/18", CustomRegex.NEW_CARD_DATE))
//    println(RegexValidation.validate("121", CustomRegex.CVV))
//    println(CustomRegex.NEW_CARD_DATE.value.toRegex().find(("02/1805/27").replace(" ", ""))?.value)
////    println(RegexValidation.validate("0121", CustomRegex.CVV))
//
////    val regex = """a([bc]+)d?""".toRegex()
////    println(regex.find("abc bbd")?.value)
//
//
//    println(CustomRegex.CARD_DATE.value.toRegex().find("11/1122/10")?.next()?.value)

//    println("1234 5678 9101112 /? \n \n 12/1234".replace(
//        Regex("\\D"),
//        ""
//    ))


}
