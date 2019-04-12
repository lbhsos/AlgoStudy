import java.util.Scanner;
import java.util.ArrayList;


public class Term {
    static int n;
    static int [] map;
    static boolean [] visit;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> cycle;
    static int count = 0;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        int tcase = scan.nextInt();

        for(int t = 0; t<tcase; t++) {
            n = scan.nextInt();
            map = new int[n];

            count = 0;

            for (int i = 0; i < n; i++) {
                map[i] = scan.nextInt();
            }

            count=0;
            visit = new boolean[n];
            cycle = new ArrayList<>();

            for(int i=0; i<n; i++){
                if(i == (map[i]-1)) {
                    visit[i] = true;
                }
            }

            for (int i = 0; i < n; i++) {
                cycle = new ArrayList<>();
                visit[i]=true;
                DFS(i);
            }
            arr.add(n-count);
        }
        printAnswer();
    }

    public static void DFS(int cur){
        cycle.add(cur);

        int next = map[cur]-1;

        if(!visit[next]){
            visit[next] = true;
            DFS(next);
        }else{
            findCycle(next);
        }

    }
    public static void findCycle(int next){
        int c = 0;

        for(int i=cycle.size()-1; i>-1; i--){
            int temp = cycle.get(i);
            c++;
            if(temp == next){
                count+=c;
            }
        }
    }

    public static void printAnswer(){

        for(int i=0; i<arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }
}
