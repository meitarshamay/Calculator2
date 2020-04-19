package calculate

import java.util.Collections.list

    fun String.splitToDoubles(): MutableMap<Int, Double> {
        val onlyNumbersStringList= this.split("+","-","/","*","^")
        val listOfD = onlyNumbersStringList.listToDouble()

        return listOfD


    }

    fun List<String>.listToDouble(): MutableMap<Int, Double> {
        val nums = mutableMapOf<Int,Double>()
        var index=0
        for(str in this) {
            nums[index] = str.toDouble()
            index++
        }
        return nums

    }

