import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Tomato {
    static int [][][] box;
    static int mm, nn, hh;
    static Queue<Position> q = new LinkedList<>();

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        mm =scan.nextInt();
        nn = scan.nextInt();
        hh = scan.nextInt();

        box = new int[hh][nn][mm];

        for(int k=0; k<hh; k++){
            for(int i=0; i<nn; i++){
                for(int j=0; j<mm; j++){
                    box[k][i][j]=scan.nextInt();
                    if(box[k][i][j] == 1){
                        q.offer(new Position(k,i,j));
                    }
                }
            }
        }
        q.offer(null);
        int depth=0;
        boolean flag = isVisited();

        if(flag) {
            depth = BFS();
            depth -=1;
            //print();
            flag = isVisited();
            if(flag) {
                depth = -1;
            }
        }
        else
            depth = 0;


        System.out.println(depth);


    }

    public static int BFS(){
        int depth =0;
        while(!q.isEmpty()){

            if(q.peek() == null){
                q.poll();
                depth++;
                q.offer(null);
                if(q.peek() == null){
                    return depth;
                }
            }

            Position p = q.poll();
            int h = p.k;
            int n = p.i;
            int m = p.j;


            //근접확인
            if((h+1)<hh) {
                if ((box[h + 1][n][m] == 0)) {
                    box[h + 1][n][m] = 1;
                    q.offer(new Position(h + 1, n, m));
                }
            }
            if((h-1)>-1) {
                if ((box[h - 1][n][m] == 0)) {
                    box[h-1][n][m]=1;
                    q.offer(new Position(h - 1, n, m));
                }
            }
            if((m+1)<mm) {
                if ((box[h][n][m + 1] == 0)) {
                    box[h][n][m+1]=1;
                    q.offer(new Position(h, n, m + 1));
                }
            }
            if((m-1)>-1) {
                if ((box[h][n][m - 1] == 0)) {
                    box[h][n][m-1]=1;
                    q.offer(new Position(h, n, m - 1));
                }
            }
            if((n-1)>-1) {
                if ((box[h][n - 1][m] == 0)) {
                    box[h][n-1][m]=1;
                    q.offer(new Position(h, n - 1, m));
                }
            }
            if((n+1)<nn) {
                if ((box[h][n + 1][m] == 0)) {
                    box[h][n+1][m]=1;
                    q.offer(new Position(h, n + 1, m));
                }
            }
            //q.offer(null);

        }
        return depth;
    }

    public static boolean isVisited(){
        boolean flag = false;

        for(int k=0; k<hh; k++){
            for(int i=0; i<nn; i++){
                for(int j=0; j<mm; j++){
                    if(box[k][i][j] == 0){
                        return true;
                    }
                }
            }
        }

        return flag;
    }

    public static boolean print(){
        boolean flag = false;

        for(int k=0; k<hh; k++){
            for(int i=0; i<nn; i++){
                for(int j=0; j<mm; j++){

                    System.out.print(box[k][i][j]+" ");

                }
                System.out.println("");
            }
            System.out.println("--------------");
        }

        return flag;
    }
}

class Position{
    int k, i, j;
    Position(int k, int i, int j){
        this.k = k;
        this.i = i;
        this.j = j;
    }
}