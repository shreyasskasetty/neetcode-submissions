class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 0;
        int maxProfit = 0;
        while(i < prices.length && j < prices.length){
            int profit = prices[j] - prices[i];
            if(prices[i] > prices[j]){
                i = j;
            }
            maxProfit = Math.max(profit, maxProfit);
            j++;
        }
        return maxProfit;
    }
}
