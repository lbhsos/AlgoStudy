import java.util.Map;
import java.util.HashMap;

class Solution {
    String[] map;
    public String intToRoman(int num) {
        map = new String[4000];
        map[1] = "I";
        map[4] = "IV";
        map[5] = "V";
        map[9] = "IX";
        map[10] = "X";
        map[40] = "XL";
        map[50] = "L";
        map[90] = "XC";
        map[100] = "C";
        map[400] = "CD";
        map[500] = "D";
        map[900] = "CM";
        map[1000] = "M";    
        
        for (int i=0; i<4; i++) {
            int tmp = (int) Math.pow(10,i);
            for (int j=1; j<4; j++) {
                map[tmp*j] = map[tmp].repeat(j);
            }
            
        }
        
        return find(num);
    }
    
    public String find(int num) {
        String tmp = "";
        for (int i=num; i>0; i--) {
            if (map[i] != null && num - i >= 0) {
                tmp += map[i];
                num -= i;
            }
            
            if (num == 0) {
                return tmp;
            }
        }
        return tmp;
    }
    
}