package stringsPlayground

class Mask {
    fun addMask(mask: String, substitute: Char? = '#') {
        println("bleus")
    }
}

fun String.addMask(mask: String, substitute: Char? = '#'): String{
    var index = 0
    var result: String = ""
    mask.forEach{ item ->
        if(index < this.length) {
            if(item == substitute) {
                result += this[index]
                index++
            } else {
                result += item
            }
        }
    }
    return result
}


fun main(){
    println("44580474856".addMask("###.###.###-##"))
}
