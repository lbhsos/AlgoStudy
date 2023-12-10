class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];

        if (obstacleGrid[0][0] == 1) {
            map[0][0] = 0;
        } else {
            map[0][0] = 1;
        }
    
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                    continue;
                }
                int left = 0;
                int up = 0;
                
                if (j - 1 >= 0 && obstacleGrid[i][j-1] != 1) {
                    left = map[i][j-1];
                } 

                if (i - 1 >= 0 && obstacleGrid[i-1][j] != 1) {
                    up = map[i-1][j];
                }
 
                map[i][j] =  left + up;
            }
        }

        return map[m-1][n-1];
    }
}
