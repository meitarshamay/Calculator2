package exeptions

class OverflowException :Exception("Oops..Overflow!")

fun Double.checkDoubleOverflow(){
    if (this >= Double.MAX_VALUE || this <= Double.MIN_VALUE ) throw OverflowException()
}