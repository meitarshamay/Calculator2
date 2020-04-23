package exeptions

class StartOrEndsWithOperation  :Exception("Oops.. you can not start with operation")

fun String.checkStartWithOperation() {

    if ((this.first() in "+-*/^") || (this.last() in "+-*/^"))
        throw  StartOrEndsWithOperation()
}