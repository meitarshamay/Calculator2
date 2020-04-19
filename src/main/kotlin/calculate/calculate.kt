package calculate

import exeptions.checkDoubleOverflow
import kotlin.math.pow


fun calculate(nums : MutableMap<Int, Double>, operations : MutableMap<Int, Char >):MutableList<Double>{

    val operationList = operations.values.toMutableList()
    val numbers = nums.values.toMutableList()


    while (operationList.isNotEmpty()){
        val key = operationList.getFirstPriorityOperator()
        val a= numbers[key]!!
        val b= numbers[key+1]!!

        numbers[key] =  when(operationList[key]){
            '+' ->  a+b
            '-' ->  a-b
            '/' ->  a/b
            '*' -> a*b
            else -> a.pow(b)
        }

        numbers[key].checkDoubleOverflow()
        operationList.removeAt(key)
        numbers.removeAt(key + 1)


    }
    return numbers
}

fun MutableList< Char >.getFirstPriorityOperator() :Int {

    val key = this.indexOfFirst { it in "*^/" }
    return if(key== -1) 0 else key
}