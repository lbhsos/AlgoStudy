class Solution {

  public int minHeightShelves(int[][] books, int shelfWidth) {
    int[] dp = new int[books.length + 1];
    
    dp[0] = 0;
    dp[1] = books[0][1];

    for (int bookNo = 2; bookNo <= books.length; bookNo++) {
      int remainingShelfWidth = shelfWidth - books[bookNo - 1][0];
      int maxHeight = books[bookNo - 1][1]; // 이전 높이
      dp[bookNo] = books[bookNo - 1][1] + dp[bookNo - 1];

      int prevPointer = bookNo - 1;
      while (prevPointer > 0 && remainingShelfWidth - books[prevPointer - 1][0] >= 0) {
        maxHeight = Math.max(maxHeight, books[prevPointer - 1][1]);
        remainingShelfWidth -= books[prevPointer - 1][0];
        dp[bookNo] = Math.min(dp[bookNo], maxHeight + dp[prevPointer - 1]);
        prevPointer--;
      }
    }

    return dp[books.length];
  }
}
