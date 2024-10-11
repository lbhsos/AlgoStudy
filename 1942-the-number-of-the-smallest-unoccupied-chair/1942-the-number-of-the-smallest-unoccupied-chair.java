import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
  public int smallestChair(int[][] times, int targetFriend) {
    PriorityQueue<FriendArrival> prq = new PriorityQueue<>();
    for (int i=0; i<times.length; i++) {
      prq.add(new FriendArrival(times[i][0], times[i][1] , i));
    }

    Map<Integer, Integer> chairs = new HashMap<>(); // chairIdx, friendIndex
    Map<Integer, List<Integer>> leavings = new HashMap<>();
    PriorityQueue<Integer> chairQueue = new PriorityQueue<>();

    // 만약에 다 비었는데 chairIdx를 갖고 있다면. -> 이걸 어떻게 알지?
    int chairIdx = -1;
    while (!prq.isEmpty()) {
      FriendArrival friendArrival = prq.poll();

      int arrivalTime = friendArrival.arrivalTime;
      int leavingTime = friendArrival.leavingTime;
      int friendIndex = friendArrival.friendIndex;

      List<Integer> deletedKeys = new ArrayList<>();
      for (int key : leavings.keySet()) {
        if (key <= arrivalTime) {
          for (int chair : leavings.get(key)) {
            chairQueue.offer(chair);
            chairs.remove(chair);
          }
          deletedKeys.add(key);
        }
      }
      
      for (int key : deletedKeys) {
        leavings.remove(key);
      }

      int chair;
      if (chairQueue.isEmpty()) {
        chairIdx++;
        chair = chairIdx;
      } else {
        chair = chairQueue.poll();
      }
      chairs.put(chair, friendIndex);
      List<Integer> values = leavings.getOrDefault(leavingTime, new ArrayList<>());
      values.add(chair);
      leavings.put(leavingTime, values);

      if (friendIndex == targetFriend) {
        return chair;
      }

    }

    return -1;
  }
}

class FriendArrival implements Comparable<FriendArrival> {
  int arrivalTime;
  int leavingTime;
  int friendIndex;

  public FriendArrival(int arrivalTime, int leavingTime, int friendIndex) {
    this.arrivalTime = arrivalTime;
    this.leavingTime = leavingTime;
    this.friendIndex = friendIndex;
  }


  @Override
  public int compareTo(FriendArrival friendArrival) {
    if (this.arrivalTime < friendArrival.arrivalTime) {
      return -1;
    }
    return 1;
  }
}

