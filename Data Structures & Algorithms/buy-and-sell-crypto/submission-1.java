class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0;

        for (int j = 1; j < prices.length; j++) {
            int currentProfit = prices[j] - prices[i];

            maxProfit = Math.max(currentProfit, maxProfit);

            if (prices[j] < prices[i]) {
                i = j;
            }
        }
        return maxProfit;
    }
}
