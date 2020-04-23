package exeptions

class InValidChar :Exception("Oops..you entered un valid charcter")

fun String.checkInValidChar() {

    val forbidden = this.filterNot { ch-> ch.isDigit() || ch in listOf('^','+','-','*','.', '/') }
    if(forbidden.isNotEmpty()) throw InValidChar()
}
fun String.checkInValidCharWithParams() {

    val forbidden = this.filterNot { ch-> ch.isLetterOrDigit() || ch in listOf('^','+','-','*','.', '/')  }
    val pattern= Regex(".[A..Z,a..z]")
    val forbidden2= pattern.containsMatchIn(this)
    if(forbidden.isNotEmpty()||forbidden2) throw InValidChar()
}