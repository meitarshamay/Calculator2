package calculate

fun String.splitToOperations(): MutableMap<Int, Char > {
    val operations = mutableMapOf<Int, Char>()
    val onlyOperations = this.filterNot { ch -> ch.isLetterOrDigit() || ch == '.' }
    var index = 0
    for (str in onlyOperations) {
        operations[index] = str
        index++
    }

    return operations
}