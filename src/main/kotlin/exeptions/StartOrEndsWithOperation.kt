package exeptions

class StartOrEndsWithOperation  :Exception("Oops.. you can not start with operation")

fun String.checkStartWithOperation() {

    if (!(this.first().isDigit()) || !(this.last().isDigit()))
        throw  StartOrEndsWithOperation()
}