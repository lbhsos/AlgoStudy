class Solution {
    private boolean canPlaceBalls(int gap, int[] position, int m) {
        // 주어진 gap 을 가지고 ball 을 위치시킬 수 있는지 postition 전체 배열을 돌면서 확인해야함.
        int prevBallPos = position[0];
        int ballsPlaced = 1; // 0 번째 index 에 놓인 ball

        for (int i=1; i<position.length && ballsPlaced < m; ++i) {
            int currPos = position[i];
            if (currPos - prevBallPos >= gap) {
                ballsPlaced += 1;
                prevBallPos = currPos;
            }
        }

        return ballsPlaced == m;
    }

    public int maxDistance(int[] position, int m) {
        int answer = 0;
        int n = position.length;
        Arrays.sort(position);
        int left = 0;
        int right = position[n-1];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceBalls(mid, position, m)) {
                answer = mid;
                left = mid + 1; // 오른쪽에 배치할 수 있는지 확인 필요 
            } else {
                right = mid - 1; // 폭을 줄여서 배치해야함 
            }
        }

        return answer;
    }
}