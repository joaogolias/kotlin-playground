package numberprinter

fun main() {
    NumberPrinterAccelerator().start()
}

fun generateEventArray(quantity: Int = 100): List<Event> {
    val arr = mutableListOf<Event>()
    for (i in 0 until quantity) {
        arr.add(Event.MY_EVENT)
    }
    return arr.toList()
}

class NumberPrinterAccelerator {
    private val THREAD_SLEEP_MIN_TIME: Long = 50
    private val THREAD_SLEEP_MAX_TIME: Long = 1000

    var increaseMomentsList = listOf(3, 5, 10, 15)

    private val accelerationCoefficient: Float by lazy {
        (THREAD_SLEEP_MAX_TIME - THREAD_SLEEP_MIN_TIME)*1f/increaseMomentsList.size
    }

    private var currentSleepTime = THREAD_SLEEP_MAX_TIME
    private var number: Int = 1
    private var accelerationType = AccelerationType.INCREASE
    private var forceStop = false
    private var minimumValueForNumber: Int = 0

    fun setInitialTime(value: Int): NumberPrinterAccelerator {
        number = value
        return this
    }

    fun setAccelerationType(type: AccelerationType): NumberPrinterAccelerator {
        accelerationType = type
        return this
    }

    fun setMinimunValue(minimum: Int): NumberPrinterAccelerator {
        minimumValueForNumber = minimum
        return this
    }

    fun stop() {
        forceStop = true
    }

    fun start(){
        forceStop = false
        val arr = generateEventArray(900)
        for(event in arr) {
            if(forceStop) {
                break
            }
            show(number, currentSleepTime)
            updateNumber()
            updateCurrentSleepTime(number)
        }
    }

    private fun updateCurrentSleepTime(currentNumber: Int) {
        if(increaseMomentsList.indexOf(currentNumber) != -1){
            val newSleepTime = currentSleepTime - accelerationCoefficient.toLong()
            if(newSleepTime >= THREAD_SLEEP_MIN_TIME) {
                currentSleepTime = newSleepTime
            }
        }
    }

    private fun updateNumber() {
        when(accelerationType) {
            AccelerationType.INCREASE -> {
                number += 1
            }
            AccelerationType.DECREASE -> {
                number -= 1
            }
        }
    }

    private fun show(number: Int, time: Long = 1000) {
        print("\r")
        print(number)
        Thread.sleep(time)
    }


}

enum class AccelerationType {
    INCREASE,
    DECREASE
}

enum class Event{
    MY_EVENT;
}

