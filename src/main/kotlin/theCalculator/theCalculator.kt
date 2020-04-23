package theCalculator

import `calculate with parameters`.checkExceptionsParams
import `calculate with parameters`.replaceParams
import calculate.calculate
import calculate.splitToDoubles
import calculate.splitToOperations
import exeptions.chekExeption
import kotlin.math.absoluteValue
import kotlin.math.pow


fun String.toCalculate(params: List<Pair<String,String>> = listOf(Pair("",""))  ):String {
    this.checkExceptionsParams()
    val fixedStr = this.replaceParams(params)
    val solution = calculate(fixedStr.splitToDoubles(),fixedStr.splitToOperations())[0]

    return (roundSolution(solution)).toString()


}

fun roundSolution(num: Double): Any {

    return when {
        num == (num.toInt()).toDouble() -> num.toInt()
        (num - num.toInt()).absoluteValue < 0.0000001 -> num.toInt()
        else -> (((num*1_000_000).toInt()).toDouble())/1_000_000
    }


}

