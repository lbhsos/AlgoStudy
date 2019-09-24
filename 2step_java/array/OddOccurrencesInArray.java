import java.util.HashMap;
import java.util.Iterator;

class OddOccurrencesInArray {
    public int solution(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int answer = 0;
        // write your code in Java SE 8
        for(int i=0; i<A.length; i++){
            int cur = A[i];
            if(hm.containsKey(cur)){
                hm.put(cur, hm.get(cur)+1);
            }else{
                hm.put(cur, 1);
            }
        }
        
        for (Integer key: hm.keySet()){
            Integer value = hm.get(key);
            if (value % 2  == 1){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
