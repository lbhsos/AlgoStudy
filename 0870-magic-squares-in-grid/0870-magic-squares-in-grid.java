class Solution {
public int numMagicSquaresInside(int[][] grid) {
    int ans = 0;
    int row = grid.length; 
    int col = grid[0].length; 

    for (int i=0; i<=row-3; i++) {
      for (int j=0; j<=col-3; j++) {
        if (isInBound(i, j, row, col) && isUnique(i, j, grid) && isAllSameSum(i, j, grid)) {
          ans++;
        }
      }
    }
    return ans;

  }

 public boolean isInBound(int i, int j, int row, int col) {
    for (int cnt=1; cnt<=3; cnt++) {
        if (i+cnt > row || j+cnt > col) {
            return false;
        }
    }
    
    return true;
 }
  public boolean isUnique(int row, int col, int[][] grid) {
    Map<Integer, Boolean> map = new HashMap<>();
    for (int i=row; i<row+3; i++) {
      for (int j=col; j<col+3; j++) {
        int num = grid[i][j];
        if (map.containsKey(num) || !(num > 0 && num < 10)) {
          return false;
        }
        map.put(num, Boolean.TRUE);
      }
    }
    return true;
  }

  public boolean isAllSameSum(int row, int col, int[][] grid) {
    // for row
    int sum = 0;
    for (int i=row; i<row+3; i++) {
      int currentSum = 0;
      for (int j=col; j<col+3; j++) {
        int num = grid[i][j];
        currentSum += num;
      }
      if (sum == 0) {
        sum = currentSum;
      }
      if (sum != currentSum) {
        return false;
      }
    }
    // for col
    for (int j=col; j<col+3; j++) {
      int currentSum = 0;
      for (int i=row; i<row+3; i++) {
        int num = grid[i][j];
        currentSum += num;
      }
      if (sum != currentSum) {
        return false;
      }
    }

    // diagonals
    int leftDiag = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2];
    if (leftDiag != sum) {
        return false;
    }
    int rightDiag = grid[row+2][col] + grid[row+1][col+1] + grid[row][col+2];
    if (rightDiag != sum) {
        return false;
    }
    return true;
  }

}