import java.util.ArrayList;
import java.util.Scanner;

public class Bridge {
    static int map [][];
    static int n;
    static boolean visit[][];
    static int cate = 1;
    static ArrayList<Island> arr = new ArrayList<>();
    static int min = 9999;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = scan.nextInt();
            }
        }

        visit = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && (!visit[i][j])) {
                    DFS(i,j);
                    cate++;
                }
            }
        }

        for(int i=0; i<arr.size(); i++){
            Island cur = arr.get(i);
            if(!cur.visit) calculate(cur);
        }

        System.out.println(min);

    }

    public static void DFS(int row, int col){
        int [] pos_i ={-1, +1, 0 , 0};
        int [] pos_j = {0,0,-1,+1};

        visit[row][col] = true;
        map[row][col] = cate;
        for(int k=0; k<4; k++){
            if((row+pos_i[k] < n) && (row+pos_i[k]>-1) && (col+pos_j[k]<n) && (col+pos_j[k]>-1)){
                if(!visit[row+pos_i[k]][col+pos_j[k]]){
                    if(map[row+pos_i[k]][col+pos_j[k]]==0){
                        arr.add(new Island(row, col, map[row][col]));
                    }
                    if((map[row+pos_i[k]][col+pos_j[k]])==1)
                        DFS(row+pos_i[k], col+pos_j[k]);
                }

            }
        }
    }


    public static void calculate(Island cur){
        cur.visit = true;

        for(int i=0; i<arr.size(); i++){
            Island next = arr.get(i);
            if((cur.num != next.num) && (!next.visit)){
                int diff = Math.abs(cur.col-next.col) +Math.abs(cur.row-next.row) -1;
                if(diff < min){
                    min = diff;
                }
            }
        }
    }
}

class Island{
    int row, col, num;
    boolean visit = false;
    Island(int row, int col, int num){
        this.row = row;
        this.col = col;
        this.num = num;
    }
}
