import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
  Map<Character, Integer> globalMap = new HashMap<>();
  boolean first = true;
  public List<String> commonChars(String[] words) {
    for (String word : words) {
      Map<Character, Integer> localMap = new HashMap<>();
      for (char c : word.toCharArray()) {
        localMap.put(c, localMap.getOrDefault(c, 0) + 1);
      }

      if (first) {
        globalMap.putAll(localMap);
        first = false;
        continue;
      }
      for(Map.Entry<Character, Integer> entry : globalMap.entrySet()) {
        char key = entry.getKey();
        int value = entry.getValue();
        if (localMap.containsKey(key)) {
          globalMap.put(key, Math.min(value, localMap.get(key)));
        } else {
          globalMap.put(key,0);
        }
      }
    }
    List<String> ans = new ArrayList<>();
    for (Character key : globalMap.keySet()) {
      for (int i=0; i<globalMap.get(key); i++) {
        ans.add(Character.toString(key));
      }
    }
    return ans;
  }
}