// 这题太难了完全没思路，核心就是定义好的状态转移方程，然后有
// 三种操作改变状态。dp[i][j]:把word1前i个变成word2前j个的步数.
// 一维的有点复杂了，双重数组是比较通用的节省空间做法.
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 初始化，当前各自需要用到左边，上边，左上边的各自
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 字符不同的话，就是左边增加一个字符或者上面增加一个字符或者修改一个字符
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + 1);
                }
                
            }
        }
        return dp[m][n];
    }
}