import java.util.Scanner;

public class Horse {
    public static int row, col;
    public static int[][] arr;
    public static int max;
    public static boolean [] route;
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        sc.nextLine();
        arr = new int[row][col];
        max = 1;
        for(int i=0; i<row; i++){
            char [] cArr = sc.nextLine().toCharArray();
            for(int j=0; j<col; j++){
                arr[i][j] = (cArr[j])-65;
            }
        }

        route = new boolean [26];
        route[arr[0][0]] = true;
        dfs(0,0,1);
        System.out.println(max);

    }

    public static void dfs(int i, int j, int count){
        //visit[i][j] = 1;

        int [][] pos ={{+1,0},{-1,0},{0,+1},{0,-1}};

        for (int k = 0; k<4; k++) {
            int nextRow = i + pos[k][0];
            int nextCol = j + pos[k][1];

            if (nextRow > -1 && nextCol > -1 && nextRow < row && nextCol < col) {
                int key = arr[nextRow][nextCol];
                if (!route[key]) {
                    max = Math.max(max, count+1);
                    dfs(nextRow, nextCol, count + 1);
                }
            }

        }
        route[arr[i][j]] = false;
    }
}

