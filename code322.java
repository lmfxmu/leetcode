// 动态规划的核心就在于状态转移
// 完全背包

// 二维数组
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        // 注意加法会溢出，用最大值/2或者amout + 1
        Arrays.fill(dp[0], amount + 1);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1); 
                }
            }
        }
        // 注意返回值，写太快了没注意
    
        return (dp[m][amount] < amount + 1) ? dp[m][amount] : -1;
    }
}

// 一维数组,实际上还可以再优化，懒得改了，就这样吧
class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[] dp = new int[amount + 1];
        // 注意加法会溢出，用最大值/2或者amout + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1); 

            }
        }
        // 注意返回值，写太快了没注意
    
        return (dp[amount] < amount + 1) ? dp[amount] : -1;


    }
}