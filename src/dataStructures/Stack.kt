package dataStructures

class Stack<T> {
    private val list: MutableList<T> = mutableListOf()
    var size: Int = 0
        get() {
            return list.size
        }

    fun at(position: Int): T? {
        if(position < list.size){
            return list[position]
        }
        return null
    }

    fun find(predicate: (T) -> Boolean): T? {
        return list.find(predicate)
    }

    fun pop(): T? {
        var lastElement: T? = null
        if(size > 0) {
            lastElement = list[size - 1]
            list.remove(lastElement)
        }
        return lastElement
    }

    fun push(element: T) {
        list.add(element)
    }

    fun printList() {
        println(list)
    }
}


fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    stack.printList()
    var lastEl = stack.pop()
    stack.printList()
    println("lastEl: ")
    println(lastEl)

    stack.pop()
    stack.printList()
    stack.push(6)
    stack.printList()
    stack.pop()
    stack.printList()
    stack.pop()
    stack.printList()
    stack.push(7)
    stack.printList()
    stack.push(8)
    stack.printList()
    println("Should be: [1, 2, 7, 8]")
}
