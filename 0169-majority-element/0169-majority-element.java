import java.util.PriorityQueue;

class Solution {
    public int majorityElement(int[] nums) {
        PriorityQueue<Dictionary> pq = new PriorityQueue<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
            pq.add(new Dictionary(num, counter.get(num)));
        }
        Dictionary majority = pq.poll();
        return majority.getNum();
    }

    class Dictionary implements Comparable<Dictionary> {
        private int num;
        private int count;
        Dictionary(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return this.num;
        }

        public int getCount() {
            return this.count;
        }

        @Override
        public int compareTo(Dictionary obj) {
            if (this.count < obj.getCount())
                return 1;
            else if (this.count > obj.getCount())
                return -1;
            return 0;
        }
    }
}
