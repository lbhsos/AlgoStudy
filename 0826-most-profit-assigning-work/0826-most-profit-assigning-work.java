import java.util.ArrayList;
import java.util.Collections;

class Solution {

  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int n = difficulty.length;
    ArrayList<Job> jobs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      jobs.add(new Job(difficulty[i], profit[i]));
    }
    Collections.sort(jobs);

    int ans = 0;
    for (int i = 0; i < worker.length; i++) {
      int ability = worker[i];
      for (Job job : jobs) {
        if (job.difficulty <= ability) {
          ans += job.profit;
          break;
        }
      }
    }
    return ans;

  }

  public class Job implements Comparable<Job> {

    int difficulty;
    int profit;

    public Job(int difficulty, int profit) {
      this.difficulty = difficulty;
      this.profit = profit;
    }

    @Override
    public int compareTo(Job job) {
      if (this.profit != job.profit) {
        return job.profit - this.profit;
      } else {
        return this.difficulty - job.difficulty;
      }

    }
  }
}
