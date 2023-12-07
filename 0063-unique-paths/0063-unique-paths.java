class Solution {

    public int uniquePaths(int m, int n) {
      int[][] map = new int[m][n];
      if (m == 1 && n == 1) {
        return 1;
      }
      
      for (int i=0; i<m; i++) {
        for (int j=0; j<n; j++) {
          if (i==0 && j==0) {
            map[i][j] = 0;
            continue;  
          }
          
          if (i - 1 < 0 || j - 1 < 0) {
            map[i][j] =  1;
            continue;
          }
          
          map[i][j] =  map[i-1][j] + map[i][j-1];
        }
      }

      return map[m-1][n-1];
    }
}
