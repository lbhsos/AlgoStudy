import java.util.Scanner;
public class StringProcessing_1100 {
    static int count=0;
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String[] box = new String [8];
        for (int i = 0; i < box.length; i++) {
            box[i]=scan.nextLine();
        }

        boolean flag = false; //odd
        //even line -> even positions are white
        for(int i=0; i<box.length; i++){
            if(i%2!=0){
                //odd line
                flag = false;
                isWhiteOn(box[i],flag);
            }else{
                //even line
                flag = true;
                isWhiteOn(box[i],flag);
            }
        }

        System.out.println(count);
        //odd line -> odd positions are white
    }

    public static void isWhiteOn(String line, boolean flag){
        for(int i=0; i<line.length()/2;i++){
            if(!flag){
                //odd positions are white
                if(line.charAt(2*i+1)=='F'){
                    count++;
                }
            }else{
                //even positions are white
                if(line.charAt(2*i)=='F'){
                    count++;
                }
            }
        }
    }

}
