import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

public class SevenDwarf {
    static int [] height;
    static final int GIVEN_VALUE = 100;
    static int first;
    static int second;
    static int [] res = new int [7];


    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        height = new int [9];


        for (int i=0; i<9 ; i++){
            height[i]=scan.nextInt();
            sum+= height[i];
        }


        boolean flag=false;
        while(!flag){
            if(sum==GIVEN_VALUE){
                break;
            }else{
                for(int i=0; i<9; i++){
                    flag = check(sum-height[i], i);
                    if(flag){
                        break;

                    }
                }
            }
        }

        moveAnswer();
        print();

    }

    public static boolean check(int first_sum, int idx){

        boolean flag = false;
        first = idx;
        for(int j=0; j<9; j++){
            if(idx == j){
                continue;
            }else{
                first_sum-=height[j];
                if(first_sum == GIVEN_VALUE){
                    second = j;
                    return true;
                }else{
                    first_sum += height[j];
                    flag = false;
                }
            }
        }

        return flag;
    }

    public static void moveAnswer(){
        int num=0;
        for(int i=0; i<9; i++) {
            if ((i == first) || (i == second)) {
                continue;
            } else {
                res[num++]=height[i];
            }
        }

    }


    public static void print(){
        Arrays.sort(res);
        for(int i=0; i<7; i++){

            System.out.println(res[i]);
        }
    }
}

