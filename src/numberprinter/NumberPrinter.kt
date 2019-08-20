package numberprinter

import kotlin.math.abs

fun main() {
    NumberPrinterAccelerator()
        .setInitialValue(1000)
        .setMinimunValue(900)
        .setAccelerationType(AccelerationType.DECREASE)
        .start()
}

class NumberPrinterAccelerator {
    private val THREAD_SLEEP_MIN_TIME: Long = 50
    private val THREAD_SLEEP_MAX_TIME: Long = 1000

    var increaseMomentsList = listOf(3, 5, 10, 20)

    private val accelerationCoefficient: Float by lazy {
        (THREAD_SLEEP_MAX_TIME - THREAD_SLEEP_MIN_TIME)*1f/increaseMomentsList.size
    }

    private var currentSleepTime = THREAD_SLEEP_MAX_TIME
    private var number: Int = 1
    private var initialValue: Int = 1
    private var accelerationType = AccelerationType.INCREASE
    private var forceStop = false
    private var minimumValueForNumber: Int = 0

    fun setInitialValue(value: Int): NumberPrinterAccelerator {
        number = value
        initialValue = value
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
        while(!forceStop) {
            show(number, currentSleepTime)
            updateNumber()
            updateCurrentSleepTime(number)
        }
    }

    private fun updateCurrentSleepTime(currentNumber: Int) {
        if(increaseMomentsList.indexOf(abs(initialValue - currentNumber)) != -1){
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
                if(number - 1 < minimumValueForNumber) {
                    forceStop = true
                } else {
                    number -= 1
                }
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

