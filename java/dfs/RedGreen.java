import java.util.Scanner;


public class RedGreen {
    static char [][] map;
    static boolean [][] visit;
    static boolean flagBlind = false; //처음엔 false, 뒤엔 true
    static int count = 1;
    static int countForBlind = 1;
    static boolean flagForZone = true;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String temp1 = scan.nextLine();
        int N = Integer.parseInt(temp1);
        map = new char [N][N];
        visit = new boolean [N][N];
        for(int i=0; i<N; i++){
            String temp = scan.nextLine();
            for(int j=0; j<N; j++){
                char tempChar = temp.charAt(j);
                map[i][j]=tempChar;
            }
        }

        RUN();
        countForBlind=1;
        flagBlind = true;
        initVisit();
        RUN();

        System.out.println(count+" "+countForBlind);
    }

    public static void RUN(){
        visit[0][0]=true;
        DFS(new Position(0, 0));

        while(true){
            boolean flag = isVisitedAll();
            if(!flag){
                break;
            }
        }
    }
    public static void initVisit(){
        int N = map.length;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
               visit[i][j]=false;
            }
        }
    }


    public static void DFS(Position p){
        visit[p.i][p.j]=true;
        boolean flagForSameChar = false;
        flagForZone = true;
        char inputChar = map[p.i][p.j];
        Position tempP=null;
        Position [] nearP= {new Position(-1, 0),new Position(+1,0),new Position(0,-1), new Position(0,+1)};
        for(int l=0; l<4; l++){
            //map 범위안에 있으면
            if ((p.i + nearP[l].i > -1) && (p.j + nearP[l].j > -1) && (p.i + nearP[l].i < map.length) && (p.j + nearP[l].j < map.length)) {
                //문자가 같으면 일반인
                tempP = new Position(p.i + nearP[l].i, p.j + nearP[l].j);
                if(!visit[tempP.i][tempP.j]) {
                    if (!flagBlind) {
                        flagForSameChar = isSameChar(inputChar, tempP);
                    } else {
                        flagForSameChar = isSameCharForBlind(inputChar, tempP);
                    }
                    checkZone(flagForSameChar, tempP);
                }
            }
        }


        //return flag;

    }
    public static void checkZone(boolean flagForSameChar, Position P){
        if(flagForSameChar) {
            DFS(P);
        }else{
            flagForZone = false;
            //DFS(P);
        }
    }

    public static boolean isSameChar(char inputChar, Position p){
        if (inputChar == map[p.i][p.j]) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isSameCharForBlind(char inputChar, Position p){
        if(inputChar == 'B'){
            if (inputChar == map[p.i][p.j]) {
                return true;
            }
        }else{
            if (('G' == map[p.i][p.j]) || ('R' == map[p.i][p.j])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVisitedAll(){
        int N = map.length;
        for(int i = 0; i < N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] ){
                    if(!flagBlind)
                        count++;
                    else
                        countForBlind++;
                    DFS(new Position(i,j));
                }
            }
        }

        return false;
    }
}

class Position{
    int i, j;
    Position(int i, int j){
        this.i = i;
        this.j = j;
    }
}
