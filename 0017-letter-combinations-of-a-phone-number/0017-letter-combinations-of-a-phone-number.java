import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    List<List<String>> orders;
    List<String> answers;
    
    public List<String> letterCombinations(String digits) {
        String[] parsedDigits = digits.split("");
        Map<String, List<String>> phoneDictionary = new HashMap<>();
        phoneDictionary.put("2", List.of("a", "b", "c"));
        phoneDictionary.put("3", List.of("d", "e", "f"));
        phoneDictionary.put("4", List.of("g", "h", "i"));
        phoneDictionary.put("5", List.of("j", "k", "l"));
        phoneDictionary.put("6", List.of("m", "n", "o"));
        phoneDictionary.put("7", List.of("p", "q", "r", "s"));
        phoneDictionary.put("8", List.of("t", "u", "v"));
        phoneDictionary.put("9", List.of("w", "x", "y", "z"));
        
        orders = new ArrayList<>();
        answers = new ArrayList<>();
        
        if (digits.length() == 0) {
            return answers;
        }
        
        for(String s : parsedDigits) {
            orders.add(phoneDictionary.get(s));
        }
        
        int maxLength = orders.size();
        for (int i=0; i<maxLength; i++) {
            run(i, maxLength, "");
        }
        
        return answers;
    }
    
    public void run(int i, int maxLength, String tmp) {
        if (i == maxLength) {
            if (tmp.length() == maxLength) {
                answers.add(tmp);
            }
            return;
        }
        
        List<String> phoneDictionary = orders.get(i);
        for (int j=0; j<phoneDictionary.size(); j++) {
            run(i+1, maxLength, tmp + phoneDictionary.get(j));    
        }
    }
}