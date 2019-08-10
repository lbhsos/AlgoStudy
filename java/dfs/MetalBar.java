import java.util.Scanner;
import java.util.ArrayList;

public class MetalBar {
    static int N;
    static int [][] nasa;
    static boolean [] visit;
    static int count=0;
    static ArrayList<Integer> arr;
    static boolean flag;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();

        for(int k=0; k<T; k++) {
            N = scan.nextInt();
            nasa = new int[N][2];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    nasa[i][j] = scan.nextInt();
                }
            }

            for (int i = 0; i < N; i++) {
                flag = false;
                arr = new ArrayList<>();
                arr.add(nasa[i][0]);
                arr.add(nasa[i][1]);
                visit = new boolean[N];
                DFS(i);
                if (flag) break;
            }
            print(k);
            System.out.println("");
        }

    }
    public static void DFS(int idx){
        visit[idx]= true;
        //count++;

        //내 뒤 == 다른애 앞
        for(int i=0; i<N;i++){
            if(!visit[i] && (nasa[i][0]==nasa[idx][1])){
                    arr.add(nasa[i][0]);
                    arr.add(nasa[i][1]);
                    if(arr.size() == 2*(N)) {
                        flag = true;
                        return;
                    }
                    DFS(i);
            }
        }

    }

    public static void print(int k){
        System.out.print("#"+(k+1)+" ");
        for(int i=0; i<arr.size(); i++){
                System.out.print(arr.get(i)+" ");
        }
    }

}

