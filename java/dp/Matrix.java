import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Matrix {
    static int N;
    static int [][] map;
    static Pos [][] p;
    static int num=0;
    static ArrayList<Ans> arr;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        for(int k=0; k<T; k++) {
            N = scan.nextInt();
            num =0;
            arr = new ArrayList<>();
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scan.nextInt();
                }
            }
            p = new Pos[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    p[i][j] = new Pos(i, j);
                }
            }

            if (map[0][0] == 0) {
                num = 0;
            } else {
                num = 1;
                arr.add(new Ans(p[0][0]));
            }
            p[0][0].cast = num;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    DP(p[i][j]);
                }
            }
            getSize();
            Collections.sort(arr);
            printAns(k);

        }

    }

    public static void DP(Pos po) {
        int curChar = po.cast;
        //이미 값 있음
        if(map[po.i][po.j] != 0){
            for(int i=-1; i<=+1; i++){
                for(int j=-1; j<+1; j++){
                    if(i*j != 0) continue;
                    if((po.i+i>-1) && (po.i+i<N) && (po.j+j>-1) && (po.j+j< N))
                        curChar = Math.max(curChar, p[po.i+i][po.j+j].cast);
                }
            }

            if(curChar == 0){
                //0 아니면서 이전 값이 0이다. -> 배정이 안되어있었다.[새연결]
                num+=1;
                curChar = num;
                arr.add(new Ans(po));
            }
        }
        po.cast = curChar;
    }

    public static void getSize(){
        int maxI, maxJ;

        for (int l = 0 ; l< arr.size(); l++){
            Ans curAns = arr.get(l);
            int start_i = curAns.start.i;
            int start_j = curAns.start.j;
            int cur_cast = curAns.start.cast;
            maxI = start_i;
            maxJ = start_j;

            for(int i=start_i; i<N; i++){
                for(int j= start_j; j<N; j++){
                    if(p[i][j].cast == cur_cast){
                        if(i > maxI) maxI = i;
                        if(j > maxJ) maxJ = j;
                    }else{
                        break;
                    }
                }
            }
            curAns.end=p[maxI][maxJ];
            curAns.i = Math.abs(maxI-start_i)+1;
            curAns.j = Math.abs(maxJ-start_j)+1;
            curAns.size = curAns.i * curAns.j;
        }


    }


    public static void printAns(int k){
        System.out.print("#"+(k+1) +" "+arr.size()+" ");
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i).i+" "+ arr.get(i).j+" ");
        }
        System.out.println("");
    }

}

class Pos {
    int i, j;
    int cast = 0;
    Pos(int i, int j){
        this.i = i;
        this.j = j;
    }
}

class Ans implements Comparable<Ans>{
    Pos start;
    Pos end = null;
    int i = 0;
    int j = 0;
    int size = 0;
    Ans(Pos start){
        this.start = start;
    }

    @Override
    public int compareTo(Ans target) {
        if(this.size > target.size)
            return 1;
        else if (this.size == target.size){
            if(this.i > target.i) return 1;
            else return -1;
        }else{
            return -1;
        }
    }
}
