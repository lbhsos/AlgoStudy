import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Human {
    private static int n;
    private static int[][] area;

    private static class Node implements Comparable<Node> {
        int n, p;

        public Node(int n, int p) {
            this.n = n;
            this.p = p;
        }

        @Override
        public int compareTo(Node o) {
            return this.p - o.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 1; t <= tcase; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            area = new int[n][n];
            int r = 0;
            while (st.hasMoreTokens()) {
                for (int j = 0; j < n; j++) area[r][j] = Integer.parseInt(st.nextToken());
                r++;
            }
            int ans = Integer.MAX_VALUE;
            for(int i = 0 ; i < n; i++) ans = Math.min(dijkstra(i), ans);
            System.out.printf("#%d %d\n", t, ans);
        }
    }

    private static int dijkstra(int cur) {
        int [] dist = new int [n];
        Arrays.fill(dist, 999);
        dist[cur] = 0;
        PriorityQueue<Node> prq = new PriorityQueue<>();
        prq.offer(new Node(cur, 0));

        while(!prq.isEmpty()){
            int node = prq.peek().n;
            int curDist = prq.peek().p;
            prq.poll();

            for(int i=0; i<n; i++){
                if(area[node][i] == 1){
                    if(dist[i] > curDist + area[node][i]){
                        dist[i] = curDist + area[node][i];
                        prq.offer(new Node(i, dist[i]));
                    }
                }
            }

        }

        int ret = 0;
        for(int i=0; i<n; i++) ret+=dist[i];
        return ret;
    }
}
