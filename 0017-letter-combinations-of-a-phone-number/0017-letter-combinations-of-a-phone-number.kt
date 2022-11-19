class Solution {
    val orders = mutableListOf<List<String>>()
    val answers: MutableList<String> = mutableListOf<String>()
    
    fun letterCombinations(digits: String): List<String> {
        val phones = mutableMapOf<Char, List<String>>()
        val parsedDigits = digits.toCharArray()
        phones.put('2', listOf<String>("a","b","c"))
        phones.put('3', listOf<String>("d", "e", "f"))
        phones.put('4', listOf<String>("g", "h", "i"))
        phones.put('5', listOf<String>("j", "k", "l"))
        phones.put('6', listOf<String>("m", "n", "o"))
        phones.put('7', listOf<String>("p", "q", "r", "s"))
        phones.put('8', listOf<String>("t", "u", "v"))
        phones.put('9', listOf<String>("w", "x", "y", "z"))

        if (digits.length == 0) {
            return answers.toList()
        }
        
        for(s in parsedDigits) {
            orders.add(phones[s] ?: throw IllegalArgumentException("No Key"));
        }

        val maxLength = orders.size;
        for (i in 0..maxLength-1) {
            run(i, maxLength, "");
        }
        
        return answers.toList()
    }
    
    fun run(i: Int, maxLength: Int, tmp: String) {
        if (i == maxLength) {
            if (tmp.length == maxLength) {
                answers.add(tmp)
            }
            return
        }

        val phoneDictionary: List<String> = orders[i]
        for (j in 0..phoneDictionary.size-1) {
            run(i+1, maxLength, tmp + phoneDictionary[j])   
        }
    }
}