package exeptions

class TooManyOperatorsInARow :Exception("Oops..you entered too many operators in a row")

fun String.checkTooManyOperatorsInARow() {

    val forbidden = this.filterIndexed { index, c ->  !c.isDigit() && !this[index+1].isDigit() }
    if(forbidden.isNotEmpty()) throw TooManyOperatorsInARow()
}

fun String.checkTooManyOperatorsInARowParams() {

    val forbidden = this.filterIndexed { index, c ->  c in "+-*/^" && this[index+1] in "+-*/^" }
    if(forbidden.isNotEmpty()) throw TooManyOperatorsInARow()
}