import java.util.Scanner;
import java.util.PriorityQueue;

public class SupplyRoute {
    static int N;
    static PriorityQueue<Point> prq;
    static int [][] map;
    static boolean [][] visit;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        //GET INPUT
        int T = scan.nextInt();
        for(int k=0; k<T; k++) {
            N = scan.nextInt();
            visit = new boolean[N][N];
            map = new int[N][N];
            scan.nextLine();

            for (int i = 0; i < N; i++) {
                String temp = scan.nextLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = temp.charAt(j) - '0';
                }
            }

            prq = new PriorityQueue<>();

            Point p = new Point(0,0);
            p.dist = 0;
            prq.offer(p);
            int dist = Dijkstra();
            System.out.println("#"+(k+1)+" " + dist);
        }
    }

    public static int Dijkstra() {
        boolean flag = true;
        while (!prq.isEmpty()) {
            Point p = prq.poll();
            if(p.i == N-1 && p.j == N-1){
                return p.dist;
            }

            Point[] candidate = {new Point(p.i + 1, p.j), new Point(p.i - 1, p.j), new Point(p.i, p.j + 1), new Point(p.i, p.j - 1)};

            for (int idx = 0; idx < candidate.length; idx++) {
                //해당 범위 안
                if ((candidate[idx].i < N) && (candidate[idx].i > -1) && (candidate[idx].j < N) && (candidate[idx].j > -1)) {
                    if(!visit[candidate[idx].i][candidate[idx].j]) {
                        //이웃 check -> '현재위치 + map 이웃까지 거리' < dist[이웃] == UPDATE
                        if (p.dist + map[candidate[idx].i][candidate[idx].j] < (candidate[idx].dist)) {
                            //더 작다면
                            candidate[idx].dist = p.dist + map[candidate[idx].i][candidate[idx].j];
                            prq.offer(candidate[idx]);
                        }
                    }
                }
            }
            //끝났으니 방문 완료
            visit[p.i][p.j] = true;
        }
        return -999;
    }

}

class Point implements Comparable<Point> {
    int i, j;
    int dist = 9999;

    Point(int i, int j){
        this.i=i;
        this.j=j;
    }

    @Override
    public int compareTo(Point targetP) {
        return this.dist <= targetP.dist ? -1: 1;
    }
}