import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class PrimeWay {
    static int [] number = new int [2];
    static Scanner scan = new Scanner(System.in);
    static Queue<Integer> q;
    static boolean [] map;
    static HashMap<Integer, ArrayList> hm;
    static int depth = 0;
    public static void main(String args[]){
        int T = scan.nextInt();
        int [][] input = new int [T][2];
        for(int i=0; i<T; i++){
            input[i]=getInput();
        }
        for(int i=0; i<T; i++){
            number=input[i];
            q = new LinkedList<>();
            hm = new HashMap<>();
            map = new boolean [10000];
            createMap();


            BFS();
            /*
            for(Integer key : hm.keySet()){

                ArrayList<Integer> arr1 = hm.get(key);

                for(int j=0; j<arr1.size(); j++) {
                    System.out.println((key) + " : " + (int)arr1.get(j));
                }

            }
            */
            System.out.println(depth);

        }


    }

    public static int[] getInput(){
        int [] tempArr = new int [2];
        tempArr[0] = scan.nextInt();
        tempArr[1] = scan.nextInt();
        return tempArr;
    }

    public static void createMap(){
        for(int i=0; i<999; i++){
            map[i]=true;
        }
        for(int i=999; i<9999; i++){ //1000~9999
            if(isPrime(i+1)==true){

            }else{

                map[i]=true;
            }
        }

        for(int i=999; i<9999; i++){
            if(map[i]==false) {
                createHashMap(i + 1);
            }
        }

    }
    public static boolean isPrime(int num){
        boolean primeFlag = true;
        for(int i=2; i<num; i++){
            if(num%i ==0){
                primeFlag = false;
                return primeFlag;
            }
        }
        return primeFlag;

    }

    public static void createHashMap(int curNum){
        String curString = (curNum)+""; //i+1
        int count =0;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int j=999;j<9999; j++){
            String numString = (j+1)+"";
            count=0;
            if((map[j]==false) && (j+1!=curNum)) {

                for (int k = 0; k < 4; k++) {
                    if (curString.charAt(k) == numString.charAt(k)) {

                        count++;
                    }
                }
                if (count == 3) {

                    arr.add(j+1);
                }
            }
        }
        if(arr.size()>0)
            hm.put(curNum, arr);


    }

    public static void BFS(){
        //소수 짝수는 안됨
        q.offer(number[0]);
        //System.out.println(number[0]);
        map[number[0]]=true;
        q.offer(-9999);
        depth=0;
        boolean flag = true;
        while(!q.isEmpty() && flag){


            if(number[0]==number[1]){
                depth=0;
                break;
            }

            if(q.peek()==-9999){
                q.remove();

                depth++;
                q.offer(-9999);
                if(q.peek()==-9999){
                    break;
                }else{
                    continue;
                }
            }


            if(q.peek() != -9999) {

                int curNum = q.poll();
                ArrayList<Integer> arrFromKey = hm.get(curNum);

                for (int connectedNum: arrFromKey) {

                    if (connectedNum == number[1]) {
                        depth++;
                        flag = false;

                        break;
                    }
                    if (!map[connectedNum - 1]) {

                        q.add(connectedNum);
                        map[connectedNum - 1] = true;
                    }


                }


            }

        }
    }




}
