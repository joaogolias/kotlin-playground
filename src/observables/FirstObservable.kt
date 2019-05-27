package observables

import java.util.*
import kotlin.properties.Delegates

class FirstObservable {
    var currentValue: String by Delegates.observable("blablabla") { property, oldValue, newValue ->
        println(property)
        println(oldValue)
        println(newValue)
    }
}

interface SecondObserver {
    fun onChangeCurrentValue()
}

fun main() {
    val fo = FirstObservable()
    fo.currentValue
    fo.currentValue = "adoleta"
    fo.currentValue = "lepetipetipola"
}
