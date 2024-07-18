class Solution {
  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    List<Pair<Integer, Integer>>[] graph = new List[n];

    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] flight : flights) {
      final int from = flight[0];
      final int to = flight[1];
      final int price = flight[2];
      graph[from].add(new Pair<>(to, price));
    }

    return dijkstra(graph, src, dst, k);
  }

  private int dijkstra(List<Pair<Integer, Integer>>[] graph, int src, int dst, int k) {
    int[][] dist = new int[graph.length][k + 2];
    Arrays.stream(dist).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
    // int[]: (distance, startPoint, leftStops)
    Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    dist[src][k + 1] = 0;
    minHeap.offer(new int[] {dist[src][k + 1], src, k + 1});

    while (!minHeap.isEmpty()) {
      final int distance = minHeap.peek()[0];
      final int startPoint = minHeap.peek()[1];
      final int leftStop = minHeap.poll()[2];
      if (startPoint == dst)
        return distance;
      if (leftStop == 0)
        continue;

      for (Pair<Integer, Integer> pair : graph[startPoint]) {
        final int to = pair.getKey();
        final int price = pair.getValue();
        if (distance + price < dist[to][leftStop - 1]) {
          dist[to][leftStop - 1] = distance + price;
          minHeap.offer(new int[] {dist[to][leftStop - 1], to, leftStop - 1});
        }
      }
    }

    return -1;
  }
}