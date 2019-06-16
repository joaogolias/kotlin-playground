package listsPlayground

fun List<String>.changeOrientation(elementsByRow: Int): List<String> {
    val rowsQuantity = (size/elementsByRow)
    val newList: MutableList<String> = mutableListOf()
    val listOfRows: MutableList<MutableList<String>> = mutableListOf()
    for(i in 0..rowsQuantity-1) {
        listOfRows.add(mutableListOf())
    }
    var listOfRowsIndex = 0
    forEachIndexed {index, item ->
        listOfRows[listOfRowsIndex].add(item)
        if(listOfRowsIndex == listOfRows.size -1) {
            listOfRowsIndex = 0
        } else {
            listOfRowsIndex++
        }
    }
    listOfRows.forEach {
        it.forEach {str ->
            newList.add(str)
        }
    }
    return newList
}



fun main() {
    val list = listOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
    println(list.changeOrientation(3))
}
