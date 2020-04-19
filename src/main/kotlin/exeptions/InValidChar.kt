package exeptions

class InValidChar :Exception("Oops..you entered un valid charcter")

fun String.checkInValidChar() {

    val forbidden = this.filterNot { ch-> ch.isDigit() || ch in listOf('^','+','-','*','.', '/') }
    if(forbidden.isNotEmpty()) throw InValidChar()
}