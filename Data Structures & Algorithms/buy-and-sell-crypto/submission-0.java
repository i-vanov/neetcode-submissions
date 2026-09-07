class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int j = 1; j < prices.length; j++) {
            int currentProfit = prices[j] - minPrice;

            maxProfit = Math.max(currentProfit, maxProfit);
            minPrice = Math.min(prices[j], minPrice);
        }
        return maxProfit;
    }
}
