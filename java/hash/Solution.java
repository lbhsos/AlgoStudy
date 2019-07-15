import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        String answer="";
        
        for(int i=0; i<participant.length; i++){
            String curPar = participant[i];
            if(hm.containsKey(curPar))
                hm.put(curPar, hm.get(curPar)+1);
            else{
                hm.put(curPar, 1);
            }
        }
        
        for(int i=0; i<completion.length; i++){
            String cur = completion[i];
            hm.put(cur, hm.get(cur)-1);
        }
        
        for(String key : hm.keySet()){
            int val = (int)hm.get(key);
            //System.out.println("key: "+key+" val: "+ val);
            if(val > 0 ){
                answer = key;
                break;
            }
        }
        
        return answer;
    }

}

