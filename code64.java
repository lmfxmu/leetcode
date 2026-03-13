// 依旧动态规划,有更好的写法，其实不用数组也行
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            dp[i + 1] += dp[i] + grid[0][i];
        }

        for (int i = 2; i <= m; i++) {
            dp[1] += grid[i - 1][0];
            for (int j = 2; j <= n; j++) {
                dp[j] = Math.min(dp[j] + grid[i - 1][j - 1], dp[j - 1] + grid[i - 1][j - 1]);
            }
        }
        return dp[n];
    }
}