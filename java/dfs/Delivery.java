import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Delivery {
    static int N;
    static Point [] p;
    static ArrayList<Integer> arr;
    static int min = 999;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int j=0; j<T; j++) {
            min = 999;
            arr = new ArrayList<>();
            N = scan.nextInt(); //N+2좌표
            p = new Point[N + 2];
            boolean[] visit = new boolean[N + 2];

            for (int i = 0; i < N + 2; i++) {
                int x_input = scan.nextInt();
                int y_input = scan.nextInt();
                p[i] = new Point(x_input, y_input);
            }
            boolean flag = false;
            visit[0] = true;
            visit = DFS(0, 0, 0, visit);

            //int max = Collections.min(arr);
            System.out.println("#"+(j+1)+" "+min);
        }
    }

    public static boolean[] DFS(int idx, int distance, int count, boolean [] visit){
        count++;
        boolean [] v = new boolean [N+2];
        v=visit.clone();
        visit[idx]=true;
        if (count == N+1){
            distance += Math.abs(p[idx].x-p[1].x)+Math.abs(p[idx].y-p[1].y);
            if(distance < min)
                min = distance;

        }else {
            for (int i = 2; i < N + 2; i++) {
                if (!visit[i]) {
                    visit = DFS(i, distance+Math.abs(p[idx].x - p[i].x) + Math.abs(p[idx].y - p[i].y), count, visit);
                }
            }
        }
        return v;
    }
}

class Point{
    int x, y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}