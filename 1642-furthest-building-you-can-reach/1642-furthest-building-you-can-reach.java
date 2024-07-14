class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    int i = 0;

    for (i=0; i<heights.length; i++) {
      if (i == heights.length - 1) {
        break;
      }
      int diff = heights[i] - heights[i+1];
      if (diff > 0) {
        continue;
      }
      diff = -1 * diff;
      bricks -= diff;
      pq.offer(diff);
      
      if (bricks < 0) {
        bricks += pq.poll();
        ladders--;
      }

      if (ladders < 0) {
        break;
      }
    }
    return i;
  }
    
}