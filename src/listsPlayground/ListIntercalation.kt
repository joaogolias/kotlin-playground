package listsPlayground

class ListIntercalation {
    init {
        val list1 = listOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
        val list2 = listOf(1,2,3,4,5)
        val list3 = mutableListOf<Int>()
        var per = list1.size/list2.size
        println(list1.size)
        println(list2.size)
        println(per)
        var j = 0
        var k = 0
        var elementOfList2 = list2[0]
        for(i in 1 until list1.size) {
            if(j >= per && k < list2.size - 1) {
                j = 0
                k++
                elementOfList2 = list2[k]
            }
            list3.add(elementOfList2)
            j++
        }
        println(list3)
    }
}

fun main(){
    val l = ListIntercalation()
}
