package exeptions

class DividedByZeroException :Exception("Oops..you can't divided by zero!")

fun String.checkDividedByZero() {
    if( this.contains("/0")) throw DividedByZeroException()
}


