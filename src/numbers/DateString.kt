package numbers

fun Long.toDateString(minutesLabel: String? = "minutos",
                      singularMinuteLabel: String? = "minuto",
                      secondsLabel: String? = "segundos",
                      singularSecondLabel: String? = "segundo",
                      andLabel: String? = "e"): String {
    var minutes = 0L
    var seconds = 0L

    if(this > 60*1000) {
        minutes = this/(60*1000)
        seconds = (this - minutes*(60*1000))/1000
    } else {
        seconds = this/1000
    }

    val minutesString = if(minutes == 1L) "$minutes $singularMinuteLabel"
                        else if(minutes == 0L) ""
                        else "$minutes $minutesLabel"

    val secondsString = if(seconds == 1L) "$seconds $singularSecondLabel"
                        else if(seconds == 0L) ""
                        else "$seconds $secondsLabel"

    val andString = if(minutesString.isNotBlank() && secondsString.isNotBlank()) " $andLabel "
                    else ""

    return "$minutesString$andString$secondsString"
}


fun main() {
    println((120*1000L).toDateString())
    println((121*1000L).toDateString())
    println((158*1000L).toDateString())
    println((100*1000L).toDateString())
    println((56*1000L).toDateString())
}
