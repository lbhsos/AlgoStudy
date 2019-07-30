import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class Line {
    static int subin;
    static int sister;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        subin = scan.nextInt();
        sister = scan.nextInt();

        int depth = BFS(subin);
        System.out.println(depth);
    }

    public static int BFS(int pos){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visit = new boolean [100001];
        visit[pos] = true;
        int depth=0;
        q.offer(pos); //현재 위치
        q.offer(-9999);

        while(!q.isEmpty()){

            if(q.peek() == -9999){
                depth++;
                q.poll();
                q.offer(-9999);
                if(q.peek() == -9999){
                    break;
                }
            }
            int n = q.poll();


            if(n == sister) {
                return depth;
            }


            if((n-1>=0) && (n-1<=100000) && (!visit[n-1])) {
                visit[n-1]=true;
                q.offer(n - 1);
            }
            if((n+1>=0) && (n+1<=100000) && (!visit[n+1])) {
                visit[n+1]=true;
                q.offer(n + 1);
            }
            if((n*2>=0) && (n*2<=100000) && (!visit[n*2])) {
                visit[n*2]=true;
                q.offer(n * 2);
            }
            if((n*(-2)>=0) && (n*(-2)<=100000) && (!visit[n*(-2)])) {
                visit[n*(-2)]=true;
                q.offer(n * (-2));
            }

        }
        return depth;
    }
}
