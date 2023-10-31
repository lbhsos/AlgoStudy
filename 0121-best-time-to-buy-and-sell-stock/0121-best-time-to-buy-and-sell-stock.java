class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int min = 10001;
        int profit;
        int answer = 0;
        for (int i=0; i<prices.length; i++) {
            int price = prices[i];
            if (price < min) {
                min = price;
            }
            profit = price - min;
            if (answer < profit) {
                answer = profit;
            }
        }

        return answer;
    }

}
