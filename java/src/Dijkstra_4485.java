import java.util.Scanner;

public class Dijkstra_4485 {

        static Scanner scan = new Scanner(System.in);
        static int [][] cave;
        static int [][] dist;

        static boolean [][] visited;
        public static void main(String args[]){
            int count =0;
            while(true){
                count++;
                int N = getN();
                if(N==0){
                    System.exit(0);
                }
                cave = new int [N][N];
                getCave(N);

                dist = new int [N][N];

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        dist[i][j]=999;
                    }
                }

                visited = new boolean [N][N];

                getDist();
                System.out.println("Problem "+count+": "+dist[N-1][N-1]);

            }
        }


        public static int getN(){
            String N = scan.nextLine();
            return Integer.parseInt(N);
        }


        public static void getCave(int N){
            for(int i=0; i<N; i++){
                String test = scan.nextLine();
                String [] testArr = test.split("\\s");

                for(int j=0; j<N; j++){
                    int t = Integer.parseInt(testArr[j]);
                    cave[i][j]=t;
                }
            }
        }


        public static void getDist(){
            //initialize
            int N = dist[0].length;
            boolean flag = true;
            dist[0][0]=cave[0][0];
            int [] cur = new int[2];

            while(flag) {

                cur = getLowestDist(N);
                int curI = cur[0];
                int curJ = cur[1];

                checkNear(curI, curJ, N);
                flag = isVisitedAll(N);
            }
        }


        public static void checkNear(int curI, int curJ, int N){
            //prev curI, curJ
            //더해서 더 작으면 update 다 없데이트하면 false로
            int prev = dist[curI][curJ];
            if((curI-1>=0) && (!visited[curI-1][curJ])){
                int temp = cave[curI-1][curJ];
                if(prev+temp<dist[curI-1][curJ]){
                    dist[curI-1][curJ]=prev+temp;
                }
            }
            if((curJ-1>=0) && (!visited[curI][curJ-1])){
                int temp = cave[curI][curJ-1];
                if(prev+temp<dist[curI][curJ-1]){
                    dist[curI][curJ-1]=prev+temp;
                }
            }
            if((curI+1<N) && (!visited[curI+1][curJ])){
                int temp = cave[curI+1][curJ];
                if(prev+temp<dist[curI+1][curJ]){
                    dist[curI+1][curJ]=prev+temp;
                }
            }
            if((curJ+1<N) && (!visited[curI][curJ+1])){
                int temp = cave[curI][curJ+1];
                if(prev+temp<dist[curI][curJ+1]){
                    dist[curI][curJ+1]=prev+temp;
                }
            }

            visited[curI][curJ]=true;

        }

        public static int[] getLowestDist(int N){
            int min = 9999;
            int [] cur = new int [2];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if((dist[i][j]<min) && (!visited[i][j])){
                        min = dist[i][j];
                        cur[0] = i;
                        cur[1] = j;
                    }
                }
            }
            return cur;
        }

        public static boolean isVisitedAll(int N){

            if(visited[N-1][N-1]){
                return false;
            }else{
                return true;
            }

        }
/*
        public static void getPrint(int N){
            for (int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(dist[i][j]+" ");
                }
                System.out.println("");
            }
        }
        public static void getvisitPrint(int N){
            for (int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(visited[i][j]+" ");
                }
                System.out.println("");
            }
            System.out.println("---------------------------------------");
        }
*/
    }



