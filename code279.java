// 依旧动态规划,完全背包问题
// 双维数组版本
class Solution {
    public int numSquares(int n) {
        // i代表选前i个，j代表容量j
        int[][] dp = new int[101][n + 1];
        // 注意，开头要赋给所有数字最大值
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        int border = (int)Math.sqrt(n);
        for (int i = 1; i <= border; i++) {
            for (int j = 0; j <= n; j++) {
                // 不选当前数or选当前数
                if (i * i > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i * i] + 1);
                }
                
            }
        }
        return dp[border][n];
    }
}

// 单数组
class Solution {
    public int numSquares(int n) {
        int border = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= border; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];

    }
}