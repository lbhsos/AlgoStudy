import java.util.Scanner;
import java.util.ArrayList;

public class Ancestor {
    static int V;
    static int [] depth;
    static int [][] parent;
    static boolean [] visit;
    static double MAX;
    static int count =0;
    static ArrayList<Integer> [] arrli;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int k=0; k<N; k++) {
            count = 0;
            V = scan.nextInt(); //노드 갯수
            int E = scan.nextInt(); // 간선 갯수
            int one = scan.nextInt();
            int two = scan.nextInt();

            depth = new int[V];
            MAX = Math.log10(V) / Math.log10(2);
            parent = new int[V][(int)MAX]; //log2V
            visit = new boolean[V];
            arrli= new ArrayList [V];

            for (int i = 0; i < V; i++) {
                for (int j = 0; j < (int) MAX; j++) {
                    parent[i][j] = -1;
                }
            }

            for (int i = 0; i < V; i++) {
                arrli[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                //실제 값 -1 로 인덱스 값 설정
                int par = scan.nextInt();
                int chi = scan.nextInt();
                arrli[par-1].add(chi-1);
                // map[par - 1][chi - 1] = 1;
            }

            // 각 노드의 depth 저장,
            // 각 노드의 parent 저장
            DFS(0);
            //parent 배열 채움
            for (int j = 0; j < (int) MAX - 1; j++) {
                for (int i = 1; i < V; i++) {
                    if (parent[i][j] != -1) {
                        parent[i][j + 1] = parent[parent[i][j]][j];
                    }
                }
            }

            int ans = findAncestor(one, two);
            int count = findAnswer(ans);

            System.out.println("#"+(k+1)+" "+ans+" "+count);
        }

    }
    public static int findAnswer(int ans){
        int num = ans-1;
        //System.out.println("ans: "+ ans);
        visit[num]=true;
        count+=1;
        for(int j=0; j<arrli[num].size(); j++){
            int n = arrli[num].get(j);
            if(!visit[n]){
                findAnswer(n+1);
                //3->4
                //4->5,6
            }
        }
        return count;

    }
    public static int findAncestor(int num1, int num2){
        int oneDep = depth[num1-1];
        int twoDep = depth[num2-1];
        int diff=0;
        if(oneDep < twoDep){
            //num1 > num2
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        diff = Math.abs(twoDep-oneDep);

        //깊이 차를 없애며 이동
        for(int j=0; diff!=0; j++){
            if(diff%2 != 0){
                num1 = parent[num1-1][j]+1;
            }
            diff = diff/2;
        }

        if(num1 != num2){
            for(int j=(int)MAX-1; j>=0; j--){
                if((parent[num1-1][j] != -1) && (parent[num1-1][j] != parent[num2-1][j])){
                    num1 = parent[num1-1][j]+1;
                    num2 = parent[num2-1][j]+1;
                    //System.out.println(num1+" "+num2);
                }
            }
            num1 = parent[num1-1][0]+1;
        }
        return num1;
    }

    public static void DFS(int num){
        for(int i=0; i<arrli[num].size(); i++){
            int next = arrli[num].get(i);
            if(depth[next]==0){
                parent[next][0]=num;
                depth[next]=depth[num]+1;
                DFS(next);
            }

        }
    }

}