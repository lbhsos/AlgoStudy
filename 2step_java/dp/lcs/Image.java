import java.util.Arrays;
import java.util.Scanner;

public class Image {
    static int n;
    static int [][] cache;
    static String x;
    static String y;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t=0; t<T; t++) {
            n = scan.nextInt();
            scan.nextLine();
            x = scan.nextLine();
            y = scan.nextLine();

            cache = new int[n + 1][n + 1];

            Arrays.fill(cache[0], 0);
            cache[1][0] = 0;

            LCS();

            int sameCount = cache[n][n];
            double div = (double) sameCount / n;
            double answer = div * 100;
            System.out.println("#"+(t+1)+" "+String.format("%.2f",answer));
        }

    }
    public static void LCS(){
        for(int i=0; i<n; i++){ //y
            char curChar = y.charAt(i);
            for(int j=0; j<x.length(); j++){ //x
                if(curChar == x.charAt(j)) {
                   cache[i+1][j+1] =cache[i][j]+1;
                }else{
                    cache[i+1][j+1] = Math.max(cache[i+1][j], cache[i][j+1]);
                }
            }
        }
    }
}
