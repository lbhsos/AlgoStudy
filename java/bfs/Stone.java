import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Stone {
    static int dongkyu;
    static int jumi;
    static boolean []visit = new boolean [100001];
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();

        dongkyu = scan.nextInt();

        jumi = scan.nextInt();

        int level = BFS(A, B);
        System.out.println(level);
    }

    public static int BFS(int A,int B){
        //System.out.println("BFS START");
        q.offer(dongkyu);
        visit[dongkyu]=true;
        q.offer(-9999);
        int lev = 0;
        while(!q.isEmpty()) {

            //System.out.println("WHILE START");
            int curPos = q.poll();

            if(curPos == -9999){
                lev++;
                q.offer(-9999);
                if(q.peek()==-9999){
                    //System.out.println("BREAK");
                    break;
                }
            }
            else {
                if (curPos == jumi) {
                    break;
                }

                int [] pos = {curPos+1, curPos-1, curPos*A, curPos*B, curPos+A, curPos+B, curPos-A, curPos-B};
                for(int i=0; i<pos.length; i++){
                    if((pos[i]>=0) && (pos[i]<=100000) && !visit[pos[i]]){
                        q.offer(pos[i]);
                        visit[pos[i]]=true;
                    }
                }

            }

        }
        return lev;

    }
}
