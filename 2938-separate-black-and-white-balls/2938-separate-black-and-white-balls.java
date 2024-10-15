import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public long minimumSteps(String s) {
    int BLACK = '1';
    int WHITE = '0';
    int n = s.length();
    long blackCount = 0;
    long whiteCount = 0;
    long answer = 0;

    int i = n-1;
    while (i >= 0) {
      if (s.charAt(i) == BLACK) {
        while (i >= 0 && s.charAt(i) == BLACK) {
          blackCount++;
          i--;
        }
        answer += (blackCount *whiteCount);
        blackCount = 0;

      } else {
        whiteCount++;
        i--;
      }
    }

    return answer;
  }
}
