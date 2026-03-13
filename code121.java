// 记录买卖的最小值
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minBuy = Integer.MAX_VALUE;
        int n = prices.length;
        for (int tmp : prices) {
            minBuy = Math.min(minBuy, tmp);
            ans = Math.max(ans, tmp - minBuy);
        }
        return ans;
    }
}