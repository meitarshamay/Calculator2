import kotlin.math.pow
//
//fun String.splitStringWithParams() {
//
//    //val onlyNumbersStringList= this.split("+","-","/","*","^")
//
//    val onlyNumbersStringList= this.fixStringWithParams().split("+","-").toMutableList()
//    val onlyMulAndDifStr = mutableListOf<String>()
//
//   for(str in onlyNumbersStringList){
//       onlyMulAndDifStr.add(organizedMul(str))
//
//   }
//
//
//
//
//}
//fun organizedMul ( str : String): String{
//    val justPowStrings = str.split("*","/").toMutableList()
//    for(index in justPowStrings.indices)
//        justPowStrings.set(index,organizePow(justPowStrings[index]))
//
//        return str
//}


//fun organizePow ( str : String): String {
//    val nums = str.split("^").toMutableList()
//    val lettersPattern= Regex("[A..Z,a..z]")
//    nums.forEachIndexed { index, a ->
//        if (!((a.contains(lettersPattern)) || nums[index + 1].contains(lettersPattern))) {
//            nums[index] = "${a.toDouble().pow(nums[index + 1].toDouble())}"
//            nums.removeAt(index + 1)
//        }
//    }
//    var size = nums.size
//    var i = 0
//        while(i < nums.size) {
//            if ((nums[i].contains(lettersPattern))|| nums[i+1].contains(lettersPattern) ) {
//                i++
//
//            }
//            else {
//                nums[i] = "${nums[i].toDouble().pow(nums[i + 1].toDouble())}"
//                nums.removeAt(i + 1)
//            }
//
//        }
//
//    return nums.joinToString ("^"  )
//
//
//}
//
//
//
//
//
//
//
//
//
//
//fun String.fixStringWithParams():String{
//    var str = this
//    var i = 0
//    while(i+1 <= str.lastIndex){
//        if((str[i].isLetterOrDigit() &&str[i+1].isLetter() ) ||(str[i].isLetter() &&str[i+1].isLetterOrDigit() )) {
//            str = str.take(i+1) + "*" +str.substring(i+1)
//            i+=2
//        }
//        else i++
//    }
//    return str
//}

