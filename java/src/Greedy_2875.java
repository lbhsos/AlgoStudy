import java.util.Scanner;
public class Greedy_2875 {
    static int count=0;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int women = scan.nextInt();
        int men = scan.nextInt();
        int internStudent = scan.nextInt();

        int team =0;
        boolean flag = true;


        while(flag){

            flag = false;
            if(women>=2){
                women-=2;
            }else{
                break;
            }
            if(men>=1){
                men-=1;
            }else{
                break;
            }
            team++;
            flag = true;
        }

        int leftWomen = women;
        int leftMen = men;

        while(true) {

            int temp = leftWomen + leftMen;
            if (temp < internStudent) {
                team -= 1;
                leftWomen += 2;
                leftMen += 1;

            }else{
                break;
            }
        }
        System.out.println(team);
    }

}
