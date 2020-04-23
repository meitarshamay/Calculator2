import `calculate with parameters`.checkExceptionsParams
import `calculate with parameters`.replaceParams
import calculate.calculate
import calculate.getFirstPriorityOperator
import calculate.splitToDoubles
import calculate.splitToOperations
import exeptions.*
import org.junit.Assert
import org.junit.Test
import theCalculator.roundSolution
import theCalculator.toCalculate

class Tests {

    @Test(expected = DividedByZeroException::class)
    fun checkDividedByZeroException(){

        "50+4/0".chekExeption()
    }

    @Test(expected = InValidChar::class)
    fun checkInValidChar(){

        "4+7-T".chekExeption()
    }

    @Test(expected = StartOrEndsWithOperation::class)
    fun checkStartOrEndWithOperation(){

        "4+7-8*".chekExeption()
    }

    @Test(expected = TooManyOperatorsInARow::class)
    fun checkTooManyOperatorsInARow(){

        "4+7---6".chekExeption()
    }


    @Test
    fun makingDoubleArr() {
       val nums = arrayOf(0.33,7.5,8.54,97.8,14.57)
        val string ="0.33+7.5-8.54/97.8*14.57"
        Assert.assertEquals(nums.joinToString (), string.splitToDoubles().values.joinToString ())
        }

    @Test
    fun makingOperationArr() {
        val operation = arrayOf('^','+','-','*', '/')
        val string ="5^4+1-4*3/6"
        Assert.assertEquals(operation.joinToString (), string.splitToOperations().values.joinToString ())
    }

    @Test
    fun checkLength (){
        val string ="5.5^4+1-4*3/6-5"
        print(string.splitToDoubles())
        Assert.assertEquals(string.splitToOperations().size+1  ,  string.splitToDoubles().size)
    }

    @Test
    fun checkFirstPriorityOperator1 (){
        val string ="5.5^4+1-4*3/6-5"
        val operations = (string.splitToOperations()).values.toMutableList()
        Assert.assertEquals(0  , operations.getFirstPriorityOperator())
    }


    @Test
    fun checkFirstPriorityOperator2 (){
        val string ="5.5+4+1-4*3/6-5"
        val operations = (string.splitToOperations()).values.toMutableList()
        Assert.assertEquals(3  , operations.getFirstPriorityOperator())
    }

    @Test
    fun checkFirstPriorityOperator3 (){
        val string ="5.5+4+1-4-36-5"
        val operations = string.splitToOperations().values.toMutableList()
        Assert.assertEquals(0  , operations.getFirstPriorityOperator())
    }

    @Test
    fun checkCalculate (){
        val string ="5+2+6-3*4+6/1"
        val operations = (string.splitToOperations())
        val nums = string.splitToDoubles()
        val a = calculate(nums,operations)

        Assert.assertEquals("7.0", a[0].toString())
    }
    @Test
    fun checkCalculate2 (){
        val string ="1+5+2+6-3*4+6/1+150-150/150-149"
        val operations = (string.splitToOperations())
        val nums = string.splitToDoubles()
        val a = calculate(nums,operations)

        Assert.assertEquals("8.0", a[0].toString())
    }

    @Test
    fun checkCalculator (){
        val string ="1+5+2+6-3*4+6/1+150-150/150-149"

        val a = string.toCalculate()

        Assert.assertEquals(8, a)
    }
    @Test
    fun checkCalculator2 (){
        val string ="5+2+6-3*4+6/1"
        val a = string.toCalculate()

        Assert.assertEquals(7, a)
    }


    @Test(expected = DividedByZeroException::class)
    fun checkCalculatorDividedByZeroException(){

        "50+4/0+5".toCalculate()
    }

    @Test(expected = InValidChar::class)
    fun checkCalculatorInValidCharException(){

        "50+4/0+5t".toCalculate()
    }
    @Test(expected = OverflowException::class)
    fun checkOverflowException1(){
        val a = Double.MAX_VALUE
        a.checkDoubleOverflow()
    }


    @Test
    fun checkRound(){
        val a = 4.0/6
        Assert.assertEquals(0.666666, roundSolution(a))

    }


    @Test
    fun checkCalculator3 (){
        val string ="1+6/3+4*2-1/3"

        val a = string.toCalculate()

        Assert.assertEquals(10.666666, a)
    }

    @Test
    fun checkCalculator4 (){
        val string ="1+6/3+4*2+0.7+0.3+0.0002*4"

        val a = string.toCalculate()

        Assert.assertEquals(12.0008, a)
    }

    //parameters

    @Test(expected = DividedByZeroException::class)
    fun checkDividedByZeroExceptionParams(){

        "50+4t/0".checkExceptionsParams()
    }

//    @Test(expected = InValidChar::class)
//    fun checkInValidCharParams(){
//
//        "4+7-T&".checkExceptionsParams()
//    }

    @Test(expected = StartOrEndsWithOperation::class)
    fun checkStartOrEndWithOperationParams(){

        "4+7ttt-8*".checkExceptionsParams()
    }

    @Test(expected = TooManyOperatorsInARow::class)
    fun checkTooManyOperatorsInARowParams(){

        "4r+7x---6".checkExceptionsParams()
    }

//    @Test
//    fun checkFixStringWithParams (){
//        val string ="5tr+1"
//
//        val a = string.fixStringWithParams()
//
//        Assert.assertEquals("5*t*r+1", a)
//    }
//
//    @Test
//    fun checkFixStringWithParams2 (){
//        val string ="5tr+1x*7X-4y/z"
//
//        val a = string.fixStringWithParams()
//
//        Assert.assertEquals("5*t*r+1*x*7*X-4*y/z", a)
//    }
//
//    @Test
//    fun checkFixStringWithParams3 (){
//        val string ="5tr*d+1x*7X-4y/z+75u-uz/t"
//
//        val a = string.fixStringWithParams()
//
//        Assert.assertEquals("5*t*r*d+1*x*7*X-4*y/z+75*u-u*z/t", a)
//    }
//
//    @Test(expected = InValidChar::class)
//    fun checkInValidCharParams2(){
//
//        "4+7-T+5.t*2".checkExceptionsParams()
//    }
//
//    @Test
//    fun checkOrganizePow(){
//        val a = organizePow("2^3^z^4^2^2^2")
//        Assert.assertEquals("2^3^z^4^2^2^2", a)
//    }

    @Test
    fun convertParams(){
        val paramsValues : List<Pair<String,String>> = listOf( Pair("tt","1.3"), Pair("X","5"), Pair("Y","7"), Pair("y","8"))
        val str = "tt+X-Y*y+t+y"
        val new= str.replaceParams(paramsValues)
        println(str)

        Assert.assertEquals("1.3+5-7*8+t+8", new)
    }


}

