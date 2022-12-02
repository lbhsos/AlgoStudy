class Solution {
    fun multiply(num1: String, num2: String): String {
        val a: BigInteger = BigInteger(num1)
        val b: BigInteger = BigInteger(num2)
        return a.multiply(b).toString()
    }
}