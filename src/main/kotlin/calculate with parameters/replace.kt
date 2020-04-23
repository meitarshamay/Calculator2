package `calculate with parameters`

import calculate.splitToOperations

fun String.replaceParams(params: List<Pair<String,String>>) : String{
    var strWithoutOps  = this.split("+","-","/","*","^").joinToString ( separator=" ", prefix  = "", postfix = " ")

    for (element in params){
        strWithoutOps= strWithoutOps.replace((element.first+" ") ,(element.second+" "))
    }

    val operation = this.filter { ch -> ch in "+^*-/" }

    for(op in operation)
        strWithoutOps= strWithoutOps.replaceFirst(' ' ,op)

    return strWithoutOps.dropLast(1)

}
