class Solution {
    fun reverse(x: Int): Int {
        var minus = false
        val intAsText: String
        if (x < 0) {
            intAsText = Integer.toString(x* (-1))
            minus = true
        } else {
            intAsText = Integer.toString(x)
        }
        
        val sb: StringBuffer = StringBuffer(intAsText)
        val reversedInt: String = sb.reverse().toString()
        var parsedInteger: Int
        try {
            parsedInteger = reversedInt.toInt()
        } catch (e: NumberFormatException) {
            return 0
        } 
        if (minus) {
            return (-1) * parsedInteger
        }
        return parsedInteger
    }
}