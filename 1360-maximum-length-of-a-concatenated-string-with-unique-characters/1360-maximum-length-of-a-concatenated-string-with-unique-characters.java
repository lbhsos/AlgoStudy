class Solution {
  static int maxCnt = 0;

  public int maxLength(List<String> arr) {
    maxCnt = 0;
    int n = arr.size();
    boolean[] visited = new boolean[n];

    for (int i = 1; i <= n; i++) {
      combination(arr, visited, 0, n, i);
    }
    return maxCnt;
  }

  static void combination(List<String> arr, boolean[] visited, int start, int n, int r) {
    if (r == 0) {
      print(arr, visited, n);
      return;
    }

    for (int i = start; i < n; i++) {
      visited[i] = true;
      combination(arr, visited, i + 1, n, r - 1);
      visited[i] = false;
    }
  }

  static void print(List<String> arr, boolean[] visited, int n) {
    String parts = "";
    for (int i = 0; i < n; i++) {
      if (visited[i]) { 
        parts += arr.get(i);
      }
    }
    if (isSafe(parts)) {
      maxCnt = Math.max(parts.length(), maxCnt);
    }
  }

  private static boolean isSafe(String parts) {
    Map<Character, Boolean> map = new HashMap<>();
    for (int i = 0; i < parts.length(); i++) {
      char c = parts.charAt(i);
      if (map.containsKey((Character) c)) {
        return false;
      }
      map.put((Character)c, Boolean.TRUE);
    }
    return true;
  }
}