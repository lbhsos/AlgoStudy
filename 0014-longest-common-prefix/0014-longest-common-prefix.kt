class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var sb: StringBuilder  = StringBuilder()
        var minLength: Int = Int.MAX_VALUE
        var minStr: String = ""
        
        for (str in strs) {
            if (str.length < minLength) {
                minLength = str.length
                minStr = str
            } 
        }
        
        var idx: Int = 0
        
        while (idx < minLength) {
            var same = true
            var c = minStr[idx]
            for (str in strs) {
                if (!c.equals(str[idx])) {
                    same = false
                    break
                }
            }    
            if (!same) {
                break
            }
            sb.append(c)
            idx += 1
        }
        
        return sb.toString()
    }
}