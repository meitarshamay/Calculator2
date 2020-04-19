package theCalculator

import calculate.calculate
import calculate.splitToDoubles
import calculate.splitToOperations
import exeptions.chekExeption
import kotlin.math.pow


fun String.toCalculate() :Any {
    this.chekExeption()
    val solution = calculate(this.splitToDoubles(),this.splitToOperations())[0]

    return roundSolution(solution)


}

fun roundSolution(num: Double): Any {

    return when {
        num == (num.toInt()).toDouble() -> num.toInt()
        (num - num.toInt()) < 0.0000001 -> num.toInt()
        else -> (((num*1_000_000).toInt()).toDouble())/1_000_000
    }


}

