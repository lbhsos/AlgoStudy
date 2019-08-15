import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class MostFrequent {
    static PriorityQueue<File> pq = new PriorityQueue<>();
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for( int k= 0; k<T; k++) {

            pq = new PriorityQueue<>();

            int cur = sc.nextInt();
            int answer = 0;

            File[] f = new File[101];

            for (int i = 0; i <= 100; i++) {
                f[i] = new File(i, 0);
            }

            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                f[num].freq += 1;
                pq.offer(f[num]);
            }

            File temp = pq.poll();
            answer = temp.score;
            //System.out.println(answer);
            arr.add((Integer) answer);
        }

        for(int i =0; i<arr.size(); i++){
            System.out.println("#"+(i+1)+ " "+arr.get(i));
        }

    }
}
class File implements Comparable<File>{
    public int score;
    public int freq;
    File(int score, int freq){
        this.score = score;
        this.freq = freq;
    }
    @Override
    public int compareTo(File obj){
        if(obj.freq > this.freq){
            return 1;
        }else if(obj.freq == this.freq){
            if(obj.score > this.score)
                return 1;
            else
                return -1;
        }else{
            return -1;
        }

    }
}

