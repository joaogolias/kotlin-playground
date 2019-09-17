package numbers

fun Long.toHourString(): String {
    var millisecondsValue = this

    var hours = 0L
    var minutes = 0L
    var seconds = 0L

    val secondsToMilliseconds = 1000
    val minutesToMilliseconds = 60*secondsToMilliseconds
    val hoursToMilliseconds = 60*minutesToMilliseconds

    if(millisecondsValue> hoursToMilliseconds) {
        hours = millisecondsValue/(hoursToMilliseconds)
    }

    millisecondsValue -= hours*hoursToMilliseconds

    if(millisecondsValue > minutesToMilliseconds) {
        minutes = millisecondsValue / minutesToMilliseconds
    }

    millisecondsValue -= minutes*minutesToMilliseconds

    if(millisecondsValue > secondsToMilliseconds) {
        seconds = millisecondsValue / secondsToMilliseconds
    }

    val hoursString = if(hours <= 0) "00" else "$hours"
    val minutesString = if(minutes <= 0) "00" else "$minutes"
    val secondsString = if(seconds <= 0) "00" else "$seconds"

    return "$hoursString:$minutesString:$secondsString"
}

fun main(){
    println((15.5*60*60*1000L).toLong().toHourString())
    println((15*60*60*1000L).toHourString())
    println((15*60*60*1000L+20*60*1000L+41*1000L).toHourString())
}
